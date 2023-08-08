package com.example.ems.Controller;

import com.example.ems.Dto.EmployeeDto;
import com.example.ems.Entity.Employee;
import com.example.ems.Service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;


@Controller
public class EmployeeRestController {

    private final EmployeeService service;

    public EmployeeRestController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/addEmployee")
    public String addEmployee(Model model, EmployeeDto employeeDto){
        return "form";
    }
    @GetMapping("/all")
    public String findAll (Model model, EmployeeDto employee){
        List<EmployeeDto> employees = service.getAllEmployees();
        model.addAttribute("employees",employees);
        return "index";
    }
}
