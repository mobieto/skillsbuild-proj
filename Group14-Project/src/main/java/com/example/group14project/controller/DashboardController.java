package com.example.group14project.controller;

import com.example.group14project.domain.Badge;
import com.example.group14project.domain.Course;
import com.example.group14project.domain.SkillsBuildUser;
import com.example.group14project.repo.BadgeRepository;
import com.example.group14project.repo.CourseRepository;
import com.example.group14project.repo.SkillsBuildUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.DecimalFormat;
import java.util.*;
import java.util.Random;
import java.util.List;


@Controller
public class DashboardController {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private SkillsBuildUserRepository repo;

    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        List<Course> courses = courseRepository.findAll();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String playerName = authentication.getName();
        SkillsBuildUser player = repo.findByName(playerName);
        Set<Course> playerCompletedCourses = new HashSet<>(player.getCourseCompletedList());
        Iterator<Course> it = courses.iterator();
        while (it.hasNext()) {
            Course course = it.next();
            if (playerCompletedCourses.contains(course)) {
                it.remove();
            }
        }
        model.addAttribute("courses", courses);


        //progress bar code
        List<Course> Courses = courseRepository.findAll();
        List<Course> completedCourses = courseRepository.findByStatus("completed");
        DecimalFormat df = new DecimalFormat("0.00");
        int completedCount = completedCourses.size();
        double totalCourses = Courses.size();
        double percentage = (double) completedCount / totalCourses * 100;
        String Percentage = df.format(percentage);
        model.addAttribute("percentage", Percentage);

        // course progress bars
        Random random = new Random();
        for (Course course : courses) {
            double coursePercent = random.nextDouble() * 100;
            String percentageCompleted = df.format(coursePercent);
            course.setPercentageCompleted(Double.parseDouble(percentageCompleted));
        }
            return "dashboard";
    }
}