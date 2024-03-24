package com.example.group14project.controller;

import com.example.group14project.repo.CourseRepository;
import com.example.group14project.repo.SkillsBuildUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CourseGoalsController {

    @Autowired
    SkillsBuildUserRepository userRepository;

    @Autowired
    CourseRepository courseRepository;

    @GetMapping("/goals")
    public String courseGoals() {
        return "courseGoals";
    }

    // persist the coursesession data somehow
    // select three different lenghts of time (gold silver bronze?) to complete the course
    // check against one of the methods in here opon course completion and award or not award a badge
}
