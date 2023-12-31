package com.example.ems.Controller;

import com.example.ems.Dto.EmployeeDto;
import com.example.ems.Service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.Lombok;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService service;

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee (@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee = service.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long id){
        EmployeeDto employeeDto = service.getEmployeeById(id);
        return ResponseEntity.ok(employeeDto);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        List <EmployeeDto> employees = service.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(
            @PathVariable("id") Long id, @RequestBody EmployeeDto employeeDto){
        EmployeeDto dto = service.updateEmployee(id, employeeDto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee( @PathVariable("id") Long id){
        service.deleteEmployee(id);
        return  ResponseEntity.ok("deleted successfully");
    }
}
