package com.example.ems.Controller;

import com.example.ems.Dto.EmployeeDto;
import com.example.ems.Service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;


@Controller
public class EmployeeRestController {

    private final EmployeeService service;

    public EmployeeRestController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String findAll (Model model, EmployeeDto employee){
        List<EmployeeDto> employees = service.getAllEmployees();
        model.addAttribute("employees",employees);
        return "index";
    }
    @GetMapping("/addEmployee")
    public String showForm(Model model, EmployeeDto employeeDto){
        return "add-employee";
    }

    @PostMapping("/addEmployee")
    public String addEmployee( EmployeeDto employeeDto){
        EmployeeDto employee = service.createEmployee(employeeDto);
        return "redirect:/";
    }

    @RequestMapping("/delete/{id}")
    public String delete( @PathVariable("id") Long id){
        service.deleteEmployee(id);
        return "redirect:/";
    }
}
