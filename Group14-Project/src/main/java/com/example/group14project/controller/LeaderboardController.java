package com.example.group14project.controller;

import com.example.group14project.domain.Leaderboard;
import com.example.group14project.repo.LeaderboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LeaderboardController {

    @Autowired
    private LeaderboardRepository repo;
    @GetMapping("/leaderboard")
    public String leaderboard(Model model){
        Iterable<Leaderboard> l = repo.findAll();
        model.addAttribute("players", l);
        return "leaderboard";
    }

}
