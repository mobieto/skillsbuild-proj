package com.example.group14project;

import com.example.group14project.domain.SkillsBuildUser;
import com.example.group14project.domain.UserRole;
import com.example.group14project.domain.Leaderboard;
import com.example.group14project.repo.LeaderboardRepository;
import com.example.group14project.repo.SkillsBuildUserRepository;
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
    private SkillsBuildUserRepository skillsBuildUserRepository;

    @Autowired
    private LeaderboardRepository leaderboardRepository;

    public static void main(String[] args) {
        SpringApplication.run(Group14ProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        // Leaderboard code below
        Leaderboard leaderboard = new Leaderboard();
        leaderboard.setPlayers(new ArrayList<>());

        SkillsBuildUser user1 = new SkillsBuildUser();
        UserRole role = new UserRole("default");
        user1.addRole(role);
        user1.setName("John");
        user1.setCoursesCompleted(0);
        user1.setPassword(passwordEncoder.encode("password"));
        leaderboard.getPlayers().add(user1);

        SkillsBuildUser user2 = new SkillsBuildUser();
        user2.addRole(role);
        user2.setName("Adam");
        user2.setCoursesCompleted(4);
        user2.setPassword(passwordEncoder.encode("password"));
        leaderboard.getPlayers().add(user2);

        SkillsBuildUser user3 = new SkillsBuildUser();
        user3.addRole(role);
        user3.setName("Roshan");
        user3.setCoursesCompleted(10);
        user3.setPassword(passwordEncoder.encode("password"));
        leaderboard.getPlayers().add(user3);



        leaderboard.getPlayers().sort(Comparator.comparingInt(SkillsBuildUser::getCoursesCompleted).reversed());
        leaderboardRepository.save(leaderboard);
    }
}
