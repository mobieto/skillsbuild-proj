package com.example.group14project.controller;

import com.example.group14project.domain.CourseSession;
import com.example.group14project.domain.SkillsBuildUser;
import com.example.group14project.repo.CourseRepository;
import com.example.group14project.repo.SkillsBuildUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.time.LocalDateTime;

@Controller
public class CourseGoalsController {

    @Autowired
    SkillsBuildUserRepository userRepository;

    @Autowired
    CourseRepository courseRepository;

    @GetMapping("/goals")
    public String courseGoals(Model model, Principal principal) {
        SkillsBuildUser user = userRepository.findByName(principal.getName());
        model.addAttribute("activeCourses", user.getActiveCourseList());
        return "courseGoals";
    }

    @RequestMapping("/addGoal")
    public String addGoal(@RequestParam String courseName, @RequestParam int goal, Principal principal) {
        SkillsBuildUser user = userRepository.findByName(principal.getName());
        CourseSession courseSession = user.getActiveCourse(courseName);
        switch (goal) {
            case 0: {
                courseSession.setEndGoal(LocalDateTime.now().plusDays(2), "Gold");
                break;
            }

            case 1: {
                courseSession.setEndGoal(LocalDateTime.now().plusDays(10), "Silver");
                break;
            }

            case 2: {
                courseSession.setEndGoal(LocalDateTime.now().plusDays(15), "Bronze");
                break;
            }
        }
        userRepository.save(user);
        return "redirect:/goals";
    }

    // persist the coursesession data somehow done
    // select three different lenghts of time (gold silver bronze?) to complete the course
    // check against one of the methods in here opon course completion and award or not award a badge
}
