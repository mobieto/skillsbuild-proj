package com.example.group14project.repo;

import com.example.group14project.domain.SkillsBuildUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SkillsBuildUserRepository extends CrudRepository<SkillsBuildUser, String> {
    public SkillsBuildUser findByName(String name);
    @Query("SELECT u FROM SkillsBuildUser u ORDER BY u.coursesCompleted DESC")
    List<SkillsBuildUser> findAllOrderByCoursesCompletedDesc();
}
