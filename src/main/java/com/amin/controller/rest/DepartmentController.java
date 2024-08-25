package com.amin.controller.rest;


import com.amin.domain.entity.Department;
import com.amin.service.DepartmentService;
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
public class DepartmentController {
    private final DepartmentService departmentService;


    @GetMapping("/department")
    public ResponseEntity<List<Department>> findAll() {
        List<Department> departmentList = departmentService.findAll();
        return ResponseEntity.ok(departmentList);
    }

    @GetMapping("/department/{departmentId}")
    public ResponseEntity<Department> findById(@PathVariable Long departmentId) {

        Department department = departmentService.findById(departmentId);
        return ResponseEntity.ok(department);
    }

    @PostMapping(value = "/department")
    public ResponseEntity<Department> save(@RequestBody Department department) {
        department = departmentService.save(department);
        return ResponseEntity.ok(department);
    }

    @PutMapping(value = "/department")
    public ResponseEntity<Department> updateDepartment(@RequestBody Department department) {
        department = departmentService.save(department);
        return ResponseEntity.ok(department);
    }

    @DeleteMapping(value = "/department/{departmentId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long departmentId) {
        departmentService.deleteById(departmentId);
        return ResponseEntity.noContent().build();
    }
}
