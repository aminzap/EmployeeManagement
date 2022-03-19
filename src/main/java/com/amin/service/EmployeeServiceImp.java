package com.amin.service;

import com.amin.entity.Employee;
import com.amin.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImp implements EmployeeService{
    EmployeeRepository employeeRepository;

    public EmployeeServiceImp(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findById(int id) {
        if (employeeRepository.findById(id).isPresent()){
            return employeeRepository.findById(id);
        }else {
            throw new RuntimeException("This id is not valid for finding: "+id);
        }
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteById(int id) {
        if (employeeRepository.findById(id).isPresent()){
            employeeRepository.deleteById(id);
        }else {
            throw new RuntimeException("This id is not valid for deleting: "+id);
        }
    }
}
