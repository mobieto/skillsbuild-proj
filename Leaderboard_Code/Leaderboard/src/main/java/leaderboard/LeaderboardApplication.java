package leaderboard;

import leaderboard.model.Leaderboard;
import leaderboard.model.Players;
import leaderboard.repo.LeaderboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
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
        player1.setCoursesCompleted(1);

        leaderboard.getPlayers().add(player1);
        player1.setLeaderboard(leaderboard);

        repo.save(leaderboard);
    }
}