package com.example.group14project.controller;

import com.example.group14project.domain.Badge;
import com.example.group14project.domain.Course;
import com.example.group14project.domain.CourseSession;
import com.example.group14project.domain.SkillsBuildUser;
import com.example.group14project.repo.CourseRepository;
import com.example.group14project.repo.SkillsBuildUserRepository;
import com.example.group14project.service.BadgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.group14project.service.CourseService;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CourseController {

    @Autowired
    private SkillsBuildUserRepository userRepository;
    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/courses")
    public String showCourses(@RequestParam(required = false) String newCourse, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String playerName = authentication.getName();
        SkillsBuildUser player = userRepository.findByName(playerName);
        List<String> courseList = new ArrayList<>(player.getActiveSessions().keySet());
        String additionalCourse = null;

        if (newCourse != null && !newCourse.isEmpty() && !courseList.contains(newCourse)) {
            additionalCourse = newCourse;
        }

        Map<String, String> elapsedTimeMap = new HashMap<>();
        for (String courseName : player.getActiveSessions().keySet()) {
            CourseSession session = player.getActiveSessions().get(courseName);
            elapsedTimeMap.put(courseName, session.getFormattedElapsedTime());
        }

        model.addAttribute("courseList", courseList);
        model.addAttribute("elapsedTimeMap", elapsedTimeMap);
        model.addAttribute("additionalCourse", additionalCourse);

        return "courses";
    }


    @PostMapping("/startSession")
    public String startSession(@RequestParam String courseName, Model model, Principal principal) {
        SkillsBuildUser player = userRepository.findByName(SecurityContextHolder.getContext().getAuthentication().getName());
        LocalDateTime startTime = LocalDateTime.now();
        CourseSession courseSession = new CourseSession(courseName, startTime);
        player.getActiveSessions().put(courseName, courseSession);
        model.addAttribute("courseStartTime", startTime);

        SkillsBuildUser user = userRepository.findByName(principal.getName());
        user.addActiveCourse(courseSession);
        userRepository.save(user);
        userRepository.save(player);
        return "redirect:/courses";
    }
    @PostMapping("/pauseSession")
    public String pauseSession(@RequestParam String courseName, Model model) {
        SkillsBuildUser player = userRepository.findByName(SecurityContextHolder.getContext().getAuthentication().getName());
        CourseSession session = player.getActiveSessions().get(courseName);
        if (session != null) {
            session.pause();
            model.addAttribute("coursePauseTime", LocalDateTime.now());
        }
        userRepository.save(player);
        return "redirect:/courses";
    }
    @PostMapping("/resumeSession")
    public String resumeSession(@RequestParam String courseName, Model model) {
        SkillsBuildUser player = userRepository.findByName(SecurityContextHolder.getContext().getAuthentication().getName());
        CourseSession session = player.getActiveSessions().get(courseName);
        if (session != null) {
            session.resume();
            model.addAttribute("courseResumeTime", LocalDateTime.now());
        }
        userRepository.save(player);
        return "redirect:/courses";
    }

    @Autowired
    private CourseService courseService;

    @Autowired
    private BadgeService badgeService;

    @GetMapping("/completeCourse")
    public String completeCourse(@RequestParam String courseName) {
        SkillsBuildUser player = userRepository.findByName(SecurityContextHolder.getContext().getAuthentication().getName());
        CourseSession session = player.getActiveSessions().get(courseName);


        player.setCoursesCompleted(player.getCoursesCompleted() + 1);
        userRepository.save(player);
        Course course = courseRepository.findByName(courseName);
        CourseSession courseSession = player.getActiveCourse(courseName);

        if (course != null) {
            if (session != null) {
                session.stop();
                course.setCompletedTime(session.getTotalTime());
                player.getActiveSessions().remove(courseName);
            }
            player.getCourseCompletedList().add(course);
            player.removeActiveCourse(courseName);

            if(courseSession.getEndGoal() != null && LocalDateTime.now().isBefore(courseSession.getEndGoal())) {
                badgeService.awardBadgeToUser(player, courseSession.getBadge());
            }
            int courseExpWorth = 100;
            player.addExp(courseExpWorth);
            userRepository.save(player);
            course.setStatus("completed");
            courseRepository.save(course);
        }

        return "redirect:/dashboard";
    }
}
