package com.amin.service;

import com.amin.domain.entity.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    public List<Department> findAll();

    public Optional<Department> findById(int id);

    public void save(Department department);

    public void deleteById(int id);
}
