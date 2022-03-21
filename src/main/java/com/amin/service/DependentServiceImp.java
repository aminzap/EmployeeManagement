package com.amin.service;

import com.amin.entity.Dependent;
import com.amin.repository.DependentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DependentServiceImp implements DependentService {
    DependentRepository dependentRepository;

    @Autowired
    public DependentServiceImp(DependentRepository dependentRepository) {
        this.dependentRepository = dependentRepository;
    }

    @Override
    public List<Dependent> findAll() {
        return dependentRepository.findAll();
    }

    @Override
    public Optional<Dependent> findById(int id) {
        if (dependentRepository.findById(id).isPresent()){
            return dependentRepository.findById(id);
        }else {
            throw new RuntimeException("This id is not valid for finding: "+id);
        }
    }

    @Override
    public void save(Dependent dependent) {
        dependentRepository.save(dependent);
    }

    @Override
    public void deleteById(int id) {
        if (dependentRepository.findById(id).isPresent()){
            dependentRepository.deleteById(id);
        }else {
            throw new RuntimeException("This id is not valid for deleting: "+id);
        }
    }
}
