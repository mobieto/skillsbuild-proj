package leaderboard.controller;
import leaderboard.model.CompleteCourseForm;
import leaderboard.model.Players;
import leaderboard.repo.PlayerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CourseController {

    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping("/completeCourse")
    public String completeCourse() {
        String playerName = "Moksh";

        Players player = playerRepository.findByName(playerName);

        if (player != null) {
            player.setCoursesCompleted(player.getCoursesCompleted() + 1);
            playerRepository.save(player);
        }

        return "redirect:/leaderboard";
    }
}


