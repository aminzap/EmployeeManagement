package service;

import come.amin.entity.Job;
import repository.JobRepository;

import java.util.List;
import java.util.Optional;

public class JobServiceImp implements JobService {
    JobRepository jobRepository;

    public JobServiceImp(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public Optional<Job> findById(int id) {
        if (jobRepository.findById(id).isPresent()){
            return jobRepository.findById(id);
        }else {
            throw new RuntimeException("This id is not valid for finding: "+id);
        }
    }

    @Override
    public void save(Job job) {
        jobRepository.save(job);
    }

    @Override
    public void deleteById(int id) {
        if (jobRepository.findById(id).isPresent()){
            jobRepository.deleteById(id);
        }else{
            throw new RuntimeException("This id is not valid for deleting: "+id);
        }
    }
}
