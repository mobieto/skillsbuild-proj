package com.example.group14project.repo;

import com.example.group14project.model.Leaderboard;
import com.example.group14project.model.Players;
import org.springframework.data.repository.CrudRepository;

public interface LeaderboardRepository extends CrudRepository<Leaderboard,Integer> {
    Leaderboard findById(int id);
    Leaderboard findByPlayers(Players players);
}
