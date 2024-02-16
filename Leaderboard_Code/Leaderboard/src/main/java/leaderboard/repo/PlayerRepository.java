package leaderboard.repo;

import leaderboard.model.Players;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlayerRepository extends CrudRepository<Players, Integer> {
    List<Players> findById(int id);
    Players findByName(String name);
}
