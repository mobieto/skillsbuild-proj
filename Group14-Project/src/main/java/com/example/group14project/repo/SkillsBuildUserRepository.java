package com.example.group14project.repo;

import com.example.group14project.domain.SkillsBuildUser;
import org.springframework.data.repository.CrudRepository;

public interface SkillsBuildUserRepository extends CrudRepository<SkillsBuildUser, String> {
    public SkillsBuildUser findByName(String name);
}
