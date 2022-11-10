package com.amin.controller.rest;

import com.amin.domain.entity.Job;
import com.amin.service.JobService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class JobController {
    JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }


    @GetMapping(value = "/job")
    public List<Job> findAll() {
        return jobService.findAll();
    }

    @GetMapping(value = "/job/{jobId}")
    public Optional<Job> findById(@PathVariable int jobId) {
        if (jobService.findById(jobId).isPresent()) {
            return jobService.findById(jobId);
        } else {
            throw new RuntimeException("This job id is not valid");
        }
    }

    @PostMapping(value = "/api")
    public Job save(@RequestBody Job job) {
        jobService.save(job);
        return job;
    }

    @PutMapping(value = "/job")
    public Job updateJob(@RequestBody Job job) {
        jobService.save(job);
        return job;
    }

    @DeleteMapping(value = "/job/{jobId}")
    public String deleteById(@PathVariable int jobId) {
        if (jobService.findById(jobId).isPresent()) {
            jobService.deleteById(jobId);
            return "This job deleted successfully bt id: " + jobId;
        } else {
            throw new RuntimeException("This job id is not valid for deleting");
        }
    }

}
