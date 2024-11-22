package com.jobPortal.jobPortal.Services.Impl;

import com.jobPortal.jobPortal.Model.Admin;
import com.jobPortal.jobPortal.Model.Job;
import com.jobPortal.jobPortal.Repository.AdminRepository;
import com.jobPortal.jobPortal.Repository.JobRepository;
import com.jobPortal.jobPortal.Services.Interface.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    @Autowired
    JobRepository jobRepository;
    @Autowired
    AdminRepository adminRepository;

    public List<Job> getJobs() {
        return jobRepository.findAll();
    }

    @Override
    public void addJob(Job job, String email) {
        jobRepository.save(job);
        Admin admin = adminRepository.getById(email);
        admin.getJobs().add(job);
        adminRepository.save(admin);

    }

    @Override
    public Job getJobById(String email, long id) {
        Admin admin = adminRepository.findById(email).orElse(null);
        List<Job> jobs = admin.getJobs();
        for(Job job : jobs) {
            if (job.getId() == id) {
                return job;
            }
        }
        return null;
    }
}
