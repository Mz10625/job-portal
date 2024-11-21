package com.jobPortal.jobPortal.Controller;
import com.jobPortal.jobPortal.Model.UserProfile;
import com.jobPortal.jobPortal.Services.Interface.JobService;
import com.jobPortal.jobPortal.Services.Interface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    JobService jobService;

    @GetMapping("/jobList")
    public String jobList(Model model) {
        model.addAttribute("jobs", jobService.getJobs());
        return "jobListUser";
    }
    @GetMapping("/updateProfile/{email}")
    public String updateProfile(@PathVariable("email") String email,Model model) {
        UserProfile userProfile = userService.getUserProfile(email);
        if(userProfile != null) {
            model.addAttribute("userProfile", userProfile);
        }
        return "profile";
    }



//    @GetMapping("/jobs")
//    public String listJobs(Model model) {
//        List<Job> jobs = jobService.listJobs();
//        model.addAttribute("jobs", jobs);
//        return "user/jobs"; // View all jobs
//    }
//
//    @GetMapping("/job/{id}")
//    public String viewJobDetails(@PathVariable Long id, Model model) {
//        Job job = jobService.getJobById(id);
//        model.addAttribute("job", job);
//        return "user/job-details"; // Show job details
//    }
//
//    @GetMapping("/job/{id}/apply")
//    public String applyForJobForm(@PathVariable Long id, Model model) {
//        Job job = jobService.getJobById(id);
//        Application application = new Application();
//        application.setJob(job);
//        model.addAttribute("application", application);
//        return "user/apply-job";
//    }
//
//    @PostMapping("/job/{id}/apply")
//    public String submitApplication(@PathVariable Long id, @ModelAttribute Application application) {
//        Job job = jobService.getJobById(id);
//        application.setJob(job);
//        application.setStatus("Pending");
//        applicationService.saveApplication(application);
//        return "redirect:/user/jobs";
//    }

}

