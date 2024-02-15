package com.example.group14project.repo;

import com.example.group14project.domain.Badge;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface BadgeRepository extends CrudRepository<Badge, Integer> {
    Badge findById(int id);

    List<Badge> findByOwnerName(String name);
}
