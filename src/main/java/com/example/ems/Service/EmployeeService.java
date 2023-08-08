package com.example.ems.Service;

import com.example.ems.Dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long id);

    EmployeeDto getAllEmployees();
}
