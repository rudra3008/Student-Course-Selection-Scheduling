package com.klef.jfsd.ps48.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.klef.jfsd.ps48.model.Course;
import com.klef.jfsd.ps48.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/dashboard")
    public String adminDashboard() {
        return "admin-dashboard";
    }
    
   
    @GetMapping("/courses")
    public String viewCourses(Model model) {
        model.addAttribute("courses", adminService.findConflictingCourses());
        return "admin-courses";
    }

    @GetMapping("/add-course")
    public String addCoursePage(Model model) {
        model.addAttribute("course", new Course());
        return "add-course";
    }

    @PostMapping("/add-course")
    public String addCourse(@ModelAttribute Course course) {
        adminService.addCourse(course);
        return "redirect:/admin/courses";
    }

    @GetMapping("/delete-course/{id}")
    public String deleteCourse(@PathVariable Long id) {
        adminService.deleteCourse(id);
        return "redirect:/admin/courses";
        
    }
    
       
}
