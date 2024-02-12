package leaderboard.repo;

import leaderboard.model.Leaderboard;
import leaderboard.model.Players;
import org.springframework.data.repository.CrudRepository;

public interface LeaderboardRepository extends CrudRepository<Leaderboard,Integer> {
    Leaderboard findById(int id);
    Leaderboard findByPlayers(Players players);

}
