package com.example.group14project;

import com.example.group14project.domain.SkillsBuildUser;
import com.example.group14project.domain.UserRole;
import com.example.group14project.model.Leaderboard;
import com.example.group14project.model.Players;
import com.example.group14project.repo.LeaderboardRepository;
import com.example.group14project.repo.SkillsBuildUserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Comparator;

@SpringBootApplication
public class Group14ProjectApplication implements CommandLineRunner {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private SkillsBuildUserRepository repository;

    @Autowired
    private LeaderboardRepository repo;

    public static void main(String[] args) {
        SpringApplication.run(Group14ProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        SkillsBuildUser user1 = new SkillsBuildUser();
        UserRole role = new UserRole("default");
        user1.setName("guest");
        user1.setPassword(passwordEncoder.encode("password"));
        user1.addRole(role);
        repository.save(user1);

        // Leaderboard code below
        Leaderboard leaderboard = new Leaderboard();
        leaderboard.setPlayers(new ArrayList<>());

        Players player1 = new Players();
        player1.setName("Moksh");
        player1.setCoursesCompleted(2);
        leaderboard.getPlayers().add(player1);
        player1.setLeaderboard(leaderboard);

        Players player2 = new Players();
        player2.setName("John");
        player2.setCoursesCompleted(3);
        leaderboard.getPlayers().add(player2);
        player2.setLeaderboard(leaderboard);

        Players player3 = new Players();
        player3.setName("Jessica");
        player3.setCoursesCompleted(1);
        leaderboard.getPlayers().add(player3);
        player3.setLeaderboard(leaderboard);

        Players player4 = new Players();
        player4.setName("Alex");
        player4.setCoursesCompleted(8);
        leaderboard.getPlayers().add(player4);
        player4.setLeaderboard(leaderboard);

        leaderboard.getPlayers().sort(Comparator.comparingInt(Players::getCoursesCompleted).reversed());
        repo.save(leaderboard);
    }
}
