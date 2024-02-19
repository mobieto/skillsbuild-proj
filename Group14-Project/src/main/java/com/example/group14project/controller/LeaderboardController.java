package com.example.group14project.controller;

import com.example.group14project.domain.Leaderboard;
import com.example.group14project.domain.SkillsBuildUser;
import com.example.group14project.repo.LeaderboardRepository;
import com.example.group14project.repo.SkillsBuildUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class LeaderboardController {

    @Autowired
    private SkillsBuildUserRepository repo;
    @GetMapping("/leaderboard")
    public String leaderboard(Model model){
        List<SkillsBuildUser> users = repo.findAllOrderByCoursesCompletedDesc();
        model.addAttribute("players", users);
        return "leaderboard";
    }

}
