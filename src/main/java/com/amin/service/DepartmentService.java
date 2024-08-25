package com.amin.service;

import com.amin.domain.entity.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService extends CrudService<Department, Long> {
    public DepartmentService(CrudRepository<Department, Long> repository) {
        super(repository);
    }
}
