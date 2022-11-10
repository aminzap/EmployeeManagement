package com.amin.controller.rest;


import com.amin.domain.entity.Employee;
import com.amin.service.EmployeeService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class EmployeeController {
    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping(value = "/employee")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping(value = "/employee/{employeeId}")
    public Optional<Employee> findById(@PathVariable int employeeId) {
        if (employeeService.findById(employeeId).isPresent()) {
            return employeeService.findById(employeeId);
        } else {
            throw new RuntimeException("This employee id is not valid: " + employeeId);
        }
    }

    @PostMapping(value = "/employee")
    public Employee save(@RequestBody Employee employee) {
        employeeService.save(employee);
        return employee;
    }

    @PutMapping(value = "/employee")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.save(employee);
        return employee;
    }

    @DeleteMapping(value = "/employee/{employeeId}")
    public String deleteById(@PathVariable int employeeId) {
        if (employeeService.findById(employeeId).isPresent()) {
            employeeService.deleteById(employeeId);
            return "Employee number: " + employeeId + " successfully deleted";
        } else {
            throw new RuntimeException("This id is not valid");
        }
    }
}
