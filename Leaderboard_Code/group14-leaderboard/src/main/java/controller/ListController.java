package controller;

import model.Leaderboard;
import model.Player;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ListController {
    Leaderboard leaderboard = new Leaderboard();

    @GetMapping("/leaderboard")
    public String showLeaderboard(Model model){
        List<Player> players = leaderboard.getPlayers();
        model.addAttribute("players", players);
        return "list";
    }
}
