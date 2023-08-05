package com.example.ems.Mapper;

import com.example.ems.Dto.EmployeeDto;
import com.example.ems.Entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );

        )
    }
}
