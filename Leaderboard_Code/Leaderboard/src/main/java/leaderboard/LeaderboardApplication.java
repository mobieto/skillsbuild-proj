package leaderboard;

import leaderboard.model.Leaderboard;
import leaderboard.model.Players;
import leaderboard.repo.LeaderboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@SpringBootApplication
public class LeaderboardApplication implements CommandLineRunner {
    @Autowired
    private LeaderboardRepository repo;

    public static void main(String[] args) {
        SpringApplication.run(LeaderboardApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
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