package leaderboard.controller;

import leaderboard.LeaderboardApplication;
import leaderboard.model.Leaderboard;
import leaderboard.model.Players;
import leaderboard.repo.LeaderboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class ListController {
    @Autowired
    private LeaderboardRepository repo;
    @GetMapping("/leaderboard")
    public String leaderboard(Model model){
        Iterable<Leaderboard> l = repo.findAll();
        model.addAttribute("players", l);
        return "list";
    }

}
