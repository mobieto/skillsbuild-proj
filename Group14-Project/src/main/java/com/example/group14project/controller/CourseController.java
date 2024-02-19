package com.example.group14project.controller;

import com.example.group14project.model.Players;
import com.example.group14project.repo.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CourseController {

    @Autowired
    private PlayerRepository repo;

    @GetMapping("/completeCourse")
    public String completeCourse() {
        String playerName = "Moksh";

        Players player = repo.findByName(playerName);

        if (player != null) {
            player.setCoursesCompleted(player.getCoursesCompleted() + 1);
            repo.save(player);
        }

        return "redirect:/dashboard";
    }
}


