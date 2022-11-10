package com.amin.service;

import com.amin.domain.entity.Job;

import java.util.List;
import java.util.Optional;

public interface JobService {
    public List<Job> findAll();

    public Optional<Job> findById(int id);

    public void save(Job job);

    public void deleteById(int id);
}
