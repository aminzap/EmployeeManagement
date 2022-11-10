package com.amin.service;

import com.amin.domain.entity.Department;
import com.amin.domain.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImp implements DepartmentService {
    DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServiceImp(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Optional<Department> findById(int id) {
        if (departmentRepository.findById(id).isPresent()) {
            return departmentRepository.findById(id);
        } else {
            throw new RuntimeException("This id is not valid for finding: " + id);
        }
    }

    @Override
    public void save(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public void deleteById(int id) {
        if (departmentRepository.findById(id).isPresent()) {
            departmentRepository.deleteById(id);
        } else {
            throw new RuntimeException("This id is not valid for deleting: " + id);
        }
    }
}
