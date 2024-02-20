package com.example.group14project.repo;

import com.example.group14project.domain.Leaderboard;
import org.springframework.data.repository.CrudRepository;

public interface LeaderboardRepository extends CrudRepository<Leaderboard,Integer> {
    Leaderboard findById(int id);
}
