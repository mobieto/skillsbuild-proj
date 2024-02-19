package com.example.group14project.repo;

import com.example.group14project.domain.Leaderboard;
import com.example.group14project.domain.SkillsBuildUser;
import org.springframework.data.repository.CrudRepository;

public interface LeaderboardRepository extends CrudRepository<Leaderboard,Integer> {
    Leaderboard findById(int id);
    Leaderboard findByPlayers(SkillsBuildUser players);
}
