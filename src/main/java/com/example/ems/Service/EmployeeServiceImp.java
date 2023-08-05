package com.example.ems.Service;

import com.example.ems.Dto.EmployeeDto;
import com.example.ems.Entity.Employee;
import com.example.ems.Mapper.EmployeeMapper;
import com.example.ems.Repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImp implements EmployeeService{

    private EmployeeRepository repository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee =  EmployeeMapper.mapToEmployee(employeeDto);

        Employee savedEmployee = repository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }


    public EmployeeDto getEmployee(Long id){

    }
}
