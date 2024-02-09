package leaderboard.controller;

import leaderboard.model.Leaderboard;
import leaderboard.model.Players;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class ListController {
    Leaderboard leaderboard = new Leaderboard();
    List<Players> player = leaderboard.getPlayers();
    @GetMapping("/leaderboard")
    public String listZoo(Model model){
        model.addAttribute("player", player);
        return "list";
    }

}
