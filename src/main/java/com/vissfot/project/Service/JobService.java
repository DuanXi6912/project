package com.vissfot.project.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vissfot.project.Model.Jobs;
import com.vissfot.project.Repository.JobRepo;

@Service
public class JobService {
    @Autowired
    private JobRepo jobRepo;

    public List<Jobs> getJobs() {
        return jobRepo.findAll();
    }

    public Jobs getJobByID(int jobID) {
        int index = getIndexByID(jobID);
        if (index != -1) {
            return getJobs().get(index);
        }
        return null;
    }
 
    public String createJob(Jobs job) {
        boolean valid = validJob(job);
        if (valid) {
            jobRepo.save(job);
            return "Create New Job";
        }
        return "Fail For Create New Job";
    }

    public String updateJob(Jobs job){
        Jobs jobFound = getJobByID(job.getJobID());
        if(jobFound != null){
            boolean valid = validJob(jobFound);
            if(valid){
                jobRepo.save(job);
                return "Update Job";
            }
            return "Missinformation";
        }
        return "Fail For Update Job";
    }

    public String deleteJob(int jobID){
        Jobs jobFound = getJobByID(jobID);
        if(jobFound != null){
            jobRepo.delete(jobFound);
            return "Delete Job ID = " + jobID;
        }
        return "Fail For Delete Job";
    }
    
    // Supplement Method
    private int getIndexByID(int jobID) {
        List<Jobs> jobs = getJobs();
        int index = 0;
        for (Jobs jobFound : jobs) {
            if (jobID == jobFound.getJobID()) {
                return index;
            }
            index++;
        }
        return -1;
    }

    private boolean validJob(Jobs job) {
        String jobTitle = job.getJobTitle();
        Double minSalary = job.getMinSalary();
        Double maxSalary = job.getMaxSalary();
        boolean valid = true;
        if (maxSalary >= minSalary) {
            // Xác định Title đã có trước đó chưa 
            for (Jobs jobFound : getJobs()) {
                    if (jobTitle.equals(jobFound.getJobTitle())) {
                        valid = false;
                    }
            }
        }
        return valid;
    }

}
