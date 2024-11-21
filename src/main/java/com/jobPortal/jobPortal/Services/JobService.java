package com.jobPortal.jobPortal.Services;


import com.jobPortal.jobPortal.Model.Job;
import com.jobPortal.jobPortal.Repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    // Get a list of all jobs
    public List<Job> listJobs() {
        return jobRepository.findAll();
    }

    // Save or update a job
    public Job saveJob(Job job) {
        return jobRepository.save(job);
    }

    // Delete a job by ID
    public void deleteJob(Long id) {
        if (!jobRepository.existsById(id)) {
            throw new RuntimeException("Job with ID " + id + " not found");
        }
        jobRepository.deleteById(id);
    }

    // Find a job by ID
    public Job getJobById(Long id) {
        return jobRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job with ID " + id + " not found"));
    }

    // Search jobs by keyword in title or description
    public List<Job> searchJobs(String keyword) {
        return jobRepository.findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(keyword, keyword);
    }
}
