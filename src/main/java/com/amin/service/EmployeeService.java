package com.amin.service;

import com.amin.domain.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService extends CrudService<Employee, Long> {

    public EmployeeService(CrudRepository<Employee, Long> repository) {
        super(repository);
    }
}
