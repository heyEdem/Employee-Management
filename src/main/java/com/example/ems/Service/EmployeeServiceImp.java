package com.example.ems.Service;

import com.example.ems.Dto.EmployeeDto;
import com.example.ems.Entity.Employee;
import com.example.ems.Exception.ResourceNotFoundException;
import com.example.ems.Mapper.EmployeeMapper;
import com.example.ems.Repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class EmployeeServiceImp implements EmployeeService{

    private EmployeeRepository repository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee =  EmployeeMapper.mapToEmployee(employeeDto);

        Employee savedEmployee = repository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById (Long id) {
        Employee employee =  repository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Employee with id:"+ id +" does not exist"));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = repository.findAll();
        return employees.stream().map((e) -> EmployeeMapper.mapToEmployeeDto(e))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {
       Employee employee = repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee with id "+ id +" not found"));

//       employee.setId(employeeDto.getId());
       employee.setFirstName(employeeDto.getFirstName());
       employee.setLastName(employeeDto.getLastName());
       employee.setEmail(employeeDto.getEmail());

       Employee updated = repository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(updated);
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee employee = repository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Employee doesnt exist"));
        repository.delete(employee);
    }

}
