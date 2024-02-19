package com.example.group14project.repo;

import com.example.group14project.domain.Players;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlayerRepository extends CrudRepository<Players, Integer> {
    List<Players> findById(int id);
    Players findByName(String name);
}
