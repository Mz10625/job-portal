package com.jobPortal.jobPortal.Services.Interface;

import com.jobPortal.jobPortal.Model.Job;

import java.util.List;

public interface JobService {
    public List<Job> getJobs();
    public void addJob(Job job, String email);
    public Job getJobById(String email, long id);
}
