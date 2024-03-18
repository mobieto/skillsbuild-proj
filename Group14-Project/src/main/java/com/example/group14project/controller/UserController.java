package com.example.group14project.controller;

import com.example.group14project.domain.Course;
import com.example.group14project.domain.SkillsBuildUser;
import com.example.group14project.domain.Badge;
import com.example.group14project.repo.CourseRepository;
import com.example.group14project.repo.SkillsBuildUserRepository;
import com.example.group14project.repo.BadgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    SkillsBuildUserRepository repository;

    @Autowired
    BadgeRepository badgeRepository;

    @Autowired
    CourseRepository repo;

    @GetMapping("/user")
    public String user(Model model, Principal principal) {
        SkillsBuildUser user = repository.findByName(principal.getName());
        model.addAttribute("user", user);

        List<Badge> playerBadges = badgeRepository.findByOwner(principal.getName());
        model.addAttribute("badges", playerBadges);

        List<Course> completedCourses = repo.findByStatus("completed");
        int completedCount = completedCourses.size();
        double totalCourses = 73;
        double percentage = (double) completedCount / totalCourses * 100;
        model.addAttribute("percentage", percentage);
        return "user";
    }
}
