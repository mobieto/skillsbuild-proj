package com.example.group14project.controller;

import com.example.group14project.domain.SkillsBuildUser;
import com.example.group14project.repo.SkillsBuildUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class FriendsLeaderboardController {

    @Autowired
    private SkillsBuildUserRepository skillsBuildUserRepository;
    @GetMapping("/friends-leaderboard")
    public String leaderboard(Model model, Principal principal){
        SkillsBuildUser user = skillsBuildUserRepository.findByName(principal.getName());

        List<SkillsBuildUser> leaderboard = skillsBuildUserRepository.findAllFriendsOrderByCoursesCompletedDesc(user);

        model.addAttribute("players", leaderboard);

        return "friendsLeaderboard";
    }

}