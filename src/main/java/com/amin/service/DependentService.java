package com.amin.service;

import com.amin.domain.entity.Dependent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class DependentService extends CrudService<Dependent, Long> {
    public DependentService(CrudRepository<Dependent, Long> repository) {
        super(repository);
    }
}
