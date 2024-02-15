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
    public String showCompleteCourseForm(Model model) {
        model.addAttribute("completeCourse", new CompleteCourseForm());
        return "completeCourse";
    }

    @PostMapping("/completeCourse")
    public String completeCourse(@ModelAttribute("completeCourseForm") CompleteCourseForm form) {
        int playerId = form.getPlayerId();
        List<Players> playersList = playerRepository.findById(playerId);
        if (!playersList.isEmpty()) {
            Players player = playersList.get(0);
            player.setCoursesCompleted(player.getCoursesCompleted() + 1);
            playerRepository.save(player);
        }
        return "redirect:/";
    }
}

