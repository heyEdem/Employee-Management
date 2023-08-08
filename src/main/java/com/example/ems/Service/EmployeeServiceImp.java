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
    public EmployeeDto getAllEmployees() {
        List<Employee> employees = repository.findAll();
        return EmployeeMapper.mapToEmployeeDto(employees);
    }


}
