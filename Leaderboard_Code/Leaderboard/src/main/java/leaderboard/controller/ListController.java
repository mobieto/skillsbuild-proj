package leaderboard.controller;

import leaderboard.LeaderboardApplication;
import leaderboard.model.Leaderboard;
import leaderboard.model.Players;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class ListController {
    Leaderboard l = new Leaderboard();
    List<Players> p = l.getPlayers();
    @GetMapping("/leaderboard")
    public String leaderboard(Model model){
        model.addAttribute("players", p );
        return "list";
    }

}
