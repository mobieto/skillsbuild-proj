package com.example.group14project.repo;

import com.example.group14project.domain.Badge;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface BadgeRepository extends CrudRepository<Badge, String> {
    Badge findByName(String name);

    List<Badge> findByOwnerName(String name);
}
