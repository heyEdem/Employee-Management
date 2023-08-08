package com.example.ems.Controller;

import com.example.ems.Dto.EmployeeDto;
import com.example.ems.Entity.Employee;
import com.example.ems.Service.EmployeeServiceImp;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class EmployeeRestController {

    private final EmployeeServiceImp service;

    public EmployeeRestController(EmployeeServiceImp service) {
        this.service = service;
    }

    @GetMapping()
    public String findAll(Model model){
        List<EmployeeDto> all = service.getAllEmployees();
        model.addAttribute("employees","all");
        return "index";
    }
}
