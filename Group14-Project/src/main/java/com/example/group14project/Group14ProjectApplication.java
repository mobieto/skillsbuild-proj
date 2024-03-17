package com.example.group14project;

import com.example.group14project.domain.SkillsBuildUser;
import com.example.group14project.domain.UserRole;
import com.example.group14project.domain.Leaderboard;
import com.example.group14project.domain.Badge;
import com.example.group14project.repo.BadgeRepository;
import com.example.group14project.repo.LeaderboardRepository;
import com.example.group14project.repo.SkillsBuildUserRepository;
import com.example.group14project.service.BadgeService;
import com.example.group14project.service.FriendService;
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
    private LeaderboardRepository leaderboardRepository;

    @Autowired
    private BadgeService badgeService;

    @Autowired
    private FriendService friendService;

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
        user1.setCoursesCompleted(5);
        user1.setPassword(passwordEncoder.encode("password"));
        leaderboard.getPlayers().add(user1);
        user1.setLeaderboard(leaderboard);

        SkillsBuildUser user2 = new SkillsBuildUser();
        user2.addRole(role);
        user2.setName("Adam");
        user2.setCoursesCompleted(4);
        user2.setPassword(passwordEncoder.encode("password"));
        leaderboard.getPlayers().add(user2);
        user2.setLeaderboard(leaderboard);

        SkillsBuildUser user3 = new SkillsBuildUser();
        user3.addRole(role);
        user3.setName("Roshan");
        user3.setCoursesCompleted(10);
        user3.setPassword(passwordEncoder.encode("password"));
        leaderboard.getPlayers().add(user3);
        user3.setLeaderboard(leaderboard);

        Badge badge1 = new Badge("First Course Complete", "Congratulations, you completed your first course!");
        badgeService.awardBadgeToUser(user1, badge1);

        Badge badge2 = new Badge("5 Courses Complete", "Nice job, you completed 5 courses!");
        badgeService.awardBadgeToUser(user1, badge2);

        leaderboardRepository.save(leaderboard);

        friendService.sendFriendRequest("John", "Adam");
        friendService.acceptFriendRequest("John", "Adam");
    }
}
