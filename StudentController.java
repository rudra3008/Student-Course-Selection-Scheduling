package com.klef.jfsd.ps48.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.klef.jfsd.ps48.model.Student;
import com.klef.jfsd.ps48.service.StudentService;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }

    @PostMapping("/register")
    public String registerStudent(@ModelAttribute Student student, Model model) {
        studentService.registerStudent(student);
        model.addAttribute("message", "Registration successful");
        return "login";
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String loginStudent(@RequestParam String email, @RequestParam String password, Model model) {
        Student student = studentService.login(email, password);
        if (student != null) {
            model.addAttribute("student", student);
            return "dashboard";
        } else {
            model.addAttribute("error", "Invalid credentials");
            return "login";
        }
    }
}
