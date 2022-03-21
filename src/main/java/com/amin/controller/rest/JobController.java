package com.amin.controller.rest;

import com.amin.entity.Job;
import com.amin.service.JobService;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public List<Job>findAll(){
        return jobService.findAll();
    }

    @GetMapping(value = "/job/{jobId}")
    public Optional<Job> findById(@PathVariable int jobId){
        if(jobService.findById(jobId).isPresent()){
            return jobService.findById(jobId);
        }else {
            throw new RuntimeException("This job id is not valid");
        }
    }

    @PostMapping(value = "/api")
    public Job save (@RequestBody Job job){
        job.setJobId(0);
        jobService.save(job);
        return null;
//        Job job=new Job(jobTitle,minSalary,maxSalary);
//        job.setJobId(0);
//        jobService.save(job);
//        return job;
    }

    @PutMapping(value = "/job")
    public Job updateJob(@RequestBody Job job){
        jobService.save(job);
        return job;
    }
    @DeleteMapping(value = "/job/{jobId}")
    public String deleteById(@PathVariable int jobId){
        if(jobService.findById(jobId).isPresent()){
            jobService.deleteById(jobId);
            return "This job deleted successfully bt id: "+jobId;
        }else {
            throw new RuntimeException("This job id is not valid for deleting");
        }
    }

}
