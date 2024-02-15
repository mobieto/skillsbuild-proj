package com.example.group14project.controller;

import com.example.group14project.domain.Course;
import com.example.group14project.repo.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        List<Course> courses = courseRepository.findAll();
        model.addAttribute("courses", courses);
        return "dashboard";
    }

}