package com.amin.controller.normal;

import com.amin.domain.entity.Job;
import com.amin.service.JobService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/job")
public class JobNormalController {
    JobService jobService;

    public JobNormalController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/list")
    public String jobList(Model model) {
        List<Job> jobList = jobService.findAll();
        model.addAttribute("jobs", jobList);
        return "/job/list-job";
    }

    @GetMapping("/add")
    public String addJob(Model model) {
        model.addAttribute("job", new Job());
        return "job/add-job";
    }

    @PostMapping("/save")
    public String saveJob(@ModelAttribute("job") Job job) {
        jobService.save(job);
        return "redirect:/job/list";
    }

    @GetMapping("/update")
    public String updateJob(@RequestParam("jobId") Long id, Model model) {
        Job job = jobService.findById(id);
        model.addAttribute("job", job);
        return "job/job-form";
    }

    @GetMapping("/delete")
    public String deleteJob(@RequestParam("jobId") Long id) {
        jobService.deleteById(id);
        return "redirect:/job/list";
    }
}
