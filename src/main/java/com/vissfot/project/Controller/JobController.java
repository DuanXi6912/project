package com.vissfot.project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vissfot.project.Model.Jobs;
import com.vissfot.project.Service.JobService;

@RestController
public class JobController {
    @Autowired
    private JobService jobService;

    @GetMapping("/jobs")
    public List<Jobs> getJobs(){
        return jobService.getJobs();
    }
    @GetMapping("/jobs/{jobID}")
    public Jobs getJobByID(@PathVariable int jobID){
        return jobService.getJobByID(jobID);
    }
    @PostMapping("/jobs")
    public String createJob(@RequestBody Jobs job){
        return jobService.createJob(job);
    }
    @PutMapping("/jobs")
    public String updateJob(@RequestBody Jobs job){
        return jobService.updateJob(job);
    }
    @DeleteMapping("/jobs/{jobID}")
    public String deleteJobByID(@PathVariable int jobID){
        return jobService.deleteJob(jobID);
    }
}
