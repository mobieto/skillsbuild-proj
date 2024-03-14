package com.example.group14project.controller;

import com.example.group14project.repo.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProgressBarController {
    @Autowired
    private CourseRepository repo;
    @GetMapping("/progress")
    public String showProgressBar(Model model) {
        return "dashboard";
    }
}