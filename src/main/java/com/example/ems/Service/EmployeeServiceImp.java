package com.example.ems.Service;

import com.example.ems.Dto.EmployeeDto;
import com.example.ems.Repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImp implements EmployeeService{

    private EmployeeRepository repository;

    public EmployeeServiceImp(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        return null;
    }
}
