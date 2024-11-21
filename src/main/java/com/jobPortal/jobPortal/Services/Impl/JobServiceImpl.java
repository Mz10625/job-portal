package com.jobPortal.jobPortal.Services.Impl;

import com.jobPortal.jobPortal.Model.Job;
import com.jobPortal.jobPortal.Repository.JobRepository;
import com.jobPortal.jobPortal.Services.Interface.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    @Autowired
    JobRepository jobRepository;

    public List<Job> getJobs() {
        return jobRepository.findAll();
    }
}
