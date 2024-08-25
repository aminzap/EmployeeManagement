package com.amin.service;

import com.amin.domain.entity.Job;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class JobService extends CrudService<Job, Long> {
    public JobService(CrudRepository<Job, Long> repository) {
        super(repository);
    }
}
