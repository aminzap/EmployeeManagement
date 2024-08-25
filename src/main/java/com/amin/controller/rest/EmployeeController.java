package com.amin.controller.rest;


import com.amin.domain.entity.Employee;
import com.amin.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping(value = "/employee")
    public ResponseEntity<List<Employee>> findAll() {
        List<Employee> employeeList = employeeService.findAll();
        return ResponseEntity.ok(employeeList);
    }

    @GetMapping(value = "/employee/{employeeId}")
    public ResponseEntity<Employee> findById(@PathVariable Long employeeId) {
        Employee employee = employeeService.findById(employeeId);
        return ResponseEntity.ok(employee);
    }

    @PostMapping(value = "/employee")
    public ResponseEntity<Employee> save(@RequestBody Employee employee) {
        employee = employeeService.save(employee);
        return ResponseEntity.ok(employee);
    }

    @PutMapping(value = "/employee")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        employee = employeeService.save(employee);
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping(value = "/employee/{employeeId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long employeeId) {
        employeeService.deleteById(employeeId);
        return ResponseEntity.noContent().build();
    }
}
