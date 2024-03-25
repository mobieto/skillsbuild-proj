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
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        DecimalFormat df = new DecimalFormat("#.##");
        String Percentage = df.format(percentage);
        model.addAttribute("percentage", Percentage);

        int level = user.getCurrentLevel();
        model.addAttribute("level", level);
        float exp = user.getTotalExp();
        model.addAttribute("exp", exp);

        return "user";
    }

    @GetMapping("/users/{username}")
    public String userPublicPage(@PathVariable String username, Model model, Principal principal) {
        SkillsBuildUser user = repository.findByName(username);
        SkillsBuildUser principalUser = repository.findByName(principal.getName());

        if (user == null) { return "userNotFound"; }

        List<Badge> playerBadges = badgeRepository.findByOwner(user.getName());

        model.addAttribute("user", user);
        model.addAttribute("badges", playerBadges);

        if (principal.getName().equals(user.getName())) { return "user"; }

        List<String> principalFriends = principalUser.getFriends().stream().map(SkillsBuildUser::getName).toList();
        List<String> principalOutgoingRequests = principalUser.getOutgoingFriendRequests().stream().map(SkillsBuildUser::getName).toList();
        List<String> principalIncomingRequests = principalUser.getIncomingFriendRequests().stream().map(SkillsBuildUser::getName).toList();

        model.addAttribute("principal", principalUser);
        model.addAttribute("principalFriends", principalFriends);
        model.addAttribute("principalOutgoingRequests", principalOutgoingRequests);
        model.addAttribute("principalIncomingRequests", principalIncomingRequests);

        return "userPublicPage";
    }
}
