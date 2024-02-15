package leaderboard.repo;

import leaderboard.model.Leaderboard;
import leaderboard.model.Players;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LeaderboardRepository extends CrudRepository<Leaderboard,Integer> {
    Leaderboard findById(int id);
    Leaderboard findByPlayers(Players players);
}
