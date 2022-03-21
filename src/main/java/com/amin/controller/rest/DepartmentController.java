package com.amin.controller.rest;


import com.amin.entity.Department;
import com.amin.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/api")
public class DepartmentController {
    DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/department")
    public List<Department> findAll(){
        return departmentService.findAll();
    }

    @GetMapping("/department/{departmentId}")
    public Optional<Department> findById(@PathVariable int departmentId){
        if (departmentService.findById(departmentId).isPresent()){
            return departmentService.findById(departmentId);
        }else {
            throw new RuntimeException("This department id is not valid: "+departmentId);
        }
    }
    @PostMapping(value = "/department")
    public Department save(@RequestBody Department department){
        department.setDepartmentId(0);
        departmentService.save(department);
        return department;
    }
    @PutMapping(value = "/department")
    public Department updateDepartment (@RequestBody Department department){
        departmentService.save(department);
        return department;
    }
    @DeleteMapping(value = "/department/{departmentId}")
    public String deleteById(@PathVariable int departmentId){
        if (departmentService.findById(departmentId).isPresent()){
            departmentService.deleteById(departmentId);
            return "This department delete successfully by id: "+departmentId;
        }else {
            throw new RuntimeException("This id is not valid: "+departmentId);
        }
    }
}
