package com.amin.service;

import com.amin.domain.entity.Job;
import com.amin.domain.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImp implements JobService {
    JobRepository jobRepository;

    @Autowired
    public JobServiceImp(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public Optional<Job> findById(int id) {
        if (jobRepository.findById(id).isPresent()) {
            return jobRepository.findById(id);
        } else {
            throw new RuntimeException("This id is not valid for finding: " + id);
        }
    }

    @Override
    public void save(Job job) {
        jobRepository.save(job);
    }

    @Override
    public void deleteById(int id) {
        if (jobRepository.findById(id).isPresent()) {
            jobRepository.deleteById(id);
        } else {
            throw new RuntimeException("This id is not valid for deleting: " + id);
        }
    }
}
