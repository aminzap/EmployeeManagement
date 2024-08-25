package com.amin.controller.rest;

import com.amin.domain.entity.Job;
import com.amin.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class JobController {
    private final JobService jobService;

    @GetMapping(value = "/job")
    public ResponseEntity<List<Job>> findAll() {
        List<Job> jobList = jobService.findAll();
        return ResponseEntity.ok(jobList);
    }

    @GetMapping(value = "/job/{jobId}")
    public ResponseEntity<Job> findById(@PathVariable Long jobId) {
        Job job = jobService.findById(jobId);
        return ResponseEntity.ok(job);
    }

    @PostMapping(value = "/api")
    public ResponseEntity<Job> save(@RequestBody Job job) {
        job = jobService.save(job);
        return ResponseEntity.ok(job);
    }

    @PutMapping(value = "/job")
    public ResponseEntity<Job> updateJob(@RequestBody Job job) {
        job = jobService.save(job);
        return ResponseEntity.ok(job);
    }

    @DeleteMapping(value = "/job/{jobId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long jobId) {
        jobService.deleteById(jobId);
        return ResponseEntity.noContent().build();
    }
}
