package com.example.group14project.controller;

import com.example.group14project.domain.Course;
import com.example.group14project.domain.CourseSession;
import com.example.group14project.domain.SkillsBuildUser;
import com.example.group14project.repo.CourseRepository;
import com.example.group14project.repo.SkillsBuildUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.group14project.service.CourseService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CourseController {

    @Autowired
    private SkillsBuildUserRepository repo;
    @Autowired
    private CourseRepository courseRepository;
    private final Map<String, CourseSession> activeSessions = new HashMap<>();

    @GetMapping("/courses")
    public String showCourses(@RequestParam(required = false) String newCourse, Model model) {
        List<String> courseList = new ArrayList<>(activeSessions.keySet());
        String additionalCourse = null;

        if (newCourse != null && !newCourse.isEmpty() && !courseList.contains(newCourse)) {
            additionalCourse = newCourse;
        }

        Map<String, String> elapsedTimeMap = new HashMap<>();
        for (String courseName : activeSessions.keySet()) {
            CourseSession session = activeSessions.get(courseName);
            elapsedTimeMap.put(courseName, session.getFormattedElapsedTime());
        }

        model.addAttribute("courseList", courseList);
        model.addAttribute("elapsedTimeMap", elapsedTimeMap);
        model.addAttribute("additionalCourse", additionalCourse);

        return "courses";
    }


    @PostMapping("/startSession")
    public String startSession(@RequestParam String courseName, Model model) {
        LocalDateTime startTime = LocalDateTime.now();
        activeSessions.put(courseName, new CourseSession(courseName, startTime));
        model.addAttribute("courseStartTime", startTime);
        return "redirect:/courses";
    }
    @PostMapping("/pauseSession")
    public String pauseSession(@RequestParam String courseName, Model model) {
        CourseSession session = activeSessions.get(courseName);
        if (session != null) {
            session.pause();
            model.addAttribute("coursePauseTime", LocalDateTime.now());
        }
        return "redirect:/courses";
    }
    @PostMapping("/resumeSession")
    public String resumeSession(@RequestParam String courseName, Model model) {
        CourseSession session = activeSessions.get(courseName);
        if (session != null) {
            session.resume();
            model.addAttribute("courseResumeTime", LocalDateTime.now());
        }
        return "redirect:/courses";
    }

    @Autowired
    private CourseService courseService;

    @GetMapping("/completeCourse")
    public String completeCourse(@RequestParam String courseName,@RequestParam String courseStatus) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String playerName = authentication.getName();
        SkillsBuildUser player = repo.findByName(playerName);

        if (player != null) {
            player.setCoursesCompleted(player.getCoursesCompleted() + 1);
            repo.save(player);

            Course course = courseRepository.findByName(courseName);
            if (course != null) {
                course.setStatus(courseStatus);
                courseRepository.save(course);
                courseRepository.delete(course);
                courseService.completeCourse(courseName);
            }
        }
        return "redirect:/dashboard";
    }
}