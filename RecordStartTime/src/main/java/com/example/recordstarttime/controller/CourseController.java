package com.example.recordstarttime.controller;

import com.example.recordstarttime.model.CourseSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.time.LocalDateTime;
import java.util.*;

@Controller
public class CourseController {

    private final Map<String, CourseSession> activeSessions = new HashMap<>();

    @GetMapping("/courses")
    public String showCourses(Model model) {
        List<String> courseList = new ArrayList<>(activeSessions.keySet());

        Map<String, String> elapsedTimeMap = new HashMap<>();
        for (String courseName : activeSessions.keySet()) {
            CourseSession session = activeSessions.get(courseName);
            elapsedTimeMap.put(courseName, session.getFormattedElapsedTime());
        }

        model.addAttribute("courseList", courseList);
        model.addAttribute("elapsedTimeMap", elapsedTimeMap);

        return "courses";
    }

    @PostMapping("/startSession")
    public String startSession(@RequestParam String courseName) {
        activeSessions.put(courseName, new CourseSession(courseName, LocalDateTime.now()));
        return "redirect:/courses";
    }

    @PostMapping("/pauseSession")
    public String pauseSession(@RequestParam String courseName) {
        CourseSession session = activeSessions.get(courseName);
        if (session != null) {
            session.pause();
        }
        return "redirect:/courses";
    }

    @PostMapping("/resumeSession")
    public String resumeSession(@RequestParam String courseName) {
        CourseSession session = activeSessions.get(courseName);
        if (session != null) {
            session.resume();
        }
        return "redirect:/courses";
    }

    @PostMapping("/addCourse")
    public String addCourse(@RequestParam String newCourse) {
        if (!activeSessions.containsKey(newCourse)) {
            activeSessions.put(newCourse, new CourseSession(newCourse, LocalDateTime.now()));
        }
        return "redirect:/courses";
    }
}
