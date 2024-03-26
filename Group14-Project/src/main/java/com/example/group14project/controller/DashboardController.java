package com.example.group14project.controller;

import com.example.group14project.domain.Badge;
import com.example.group14project.domain.Course;
import com.example.group14project.domain.CourseSession;
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
        courses.removeIf(playerCompletedCourses::contains);
        model.addAttribute("courses", courses);
        model.addAttribute("completed_courses", player.getCourseCompletedList());
        Map<String, CourseSession> activeSessions = player.getActiveSessions();
        List<String> keys = new ArrayList<>();
        for (Map.Entry<String, CourseSession> entry : activeSessions.entrySet()) {
            keys.add(entry.getKey());
        }
        model.addAttribute("activeSessions", player.getActiveSessions());


        //progress bar code
        List<Course> Courses = courseRepository.findAll();
        List<Course> completedCourses = player.getCourseCompletedList();
        DecimalFormat df = new DecimalFormat("0");
        int completedCount = completedCourses.size();
        double totalCourses = Courses.size();
        double percentage = (double) completedCount / totalCourses * 100;
        String Percentage = df.format(percentage);
        model.addAttribute("percentage", Percentage);

        // course progress bars
        Random random = new Random();
        for (Course course : courses) {
            if (course.getPercentageCompleted() == null) {
                double coursePercent = random.nextDouble() * 100;
                String percentageCompleted = df.format(coursePercent);
                course.setPercentageCompleted(percentageCompleted);
                courseRepository.save(course);
            }
        }
        return "dashboard";
    }
}