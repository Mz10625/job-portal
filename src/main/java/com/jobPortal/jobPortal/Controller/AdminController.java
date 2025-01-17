package com.jobPortal.jobPortal.Controller;

import com.jobPortal.jobPortal.Services.Interface.AdminService;
import com.jobPortal.jobPortal.Services.Interface.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;
    @Autowired
    JobService jobService;

    @GetMapping("/jobList")
    public String jobList(Model model) {
        model.addAttribute("jobs", jobService.getJobs());
        return "jobListAdmin";
    }




//
//
//
//    // List all jobs
//    @GetMapping("/jobs")
//    public String listJobs(Model model) {
//        model.addAttribute("jobs", jobService.listJobs());
//        return "admin/jobs";
//    }
//
//    // Form to create a new job
//    @GetMapping("/jobs/create")
//    public String createJobForm(Model model) {
//        model.addAttribute("job", new Job());
//        return "admin/create-job";
//    }
//
//    // Save a new job
//    @PostMapping("/jobs")
//    public String saveJob(@ModelAttribute Job job) {
//        jobService.saveJob(job);
//        return "redirect:/admin/jobs";
//    }
//
//    // Delete a job
//    @GetMapping("/jobs/delete/{id}")
//    public String deleteJob(@PathVariable Long id) {
//        jobService.deleteJob(id);
//        return "redirect:/admin/jobs";
//    }
//
//    // View all applications for a specific job
//    @GetMapping("/applications/{jobId}")
//    public String viewApplications(@PathVariable Long jobId, Model model) {
//        model.addAttribute("applications", applicationService.getApplicationsByJobId(jobId));
//        return "admin/applications";
//    }
//
//    // Update application status
//    @PostMapping("/applications/update/{id}")
//    public String updateApplicationStatus(@PathVariable Long id, @RequestParam String status) {
//        applicationService.updateApplicationStatus(id, status);
//        return "redirect:/admin/applications/{id}";
//    }
}
