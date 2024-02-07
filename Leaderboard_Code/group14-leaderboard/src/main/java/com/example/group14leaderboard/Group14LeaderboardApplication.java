package com.example.group14leaderboard;

import model.Leaderboard;
import model.Player;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class Group14LeaderboardApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(Group14LeaderboardApplication.class, args);
    }
    ArrayList<String> list = new ArrayList<String>();
    public void run(String... args) throws Exception {
        Leaderboard leaderboard = new Leaderboard();
        leaderboard.setPlayers(new ArrayList<>());

        Player player = new Player();
        player.setName("Moksh");
        player.setScore(100);

        leaderboard.getPlayers().add(player);
    }
}
