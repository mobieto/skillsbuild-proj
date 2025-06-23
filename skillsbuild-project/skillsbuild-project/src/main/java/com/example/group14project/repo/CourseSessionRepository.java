package com.example.group14project.repo;

import com.example.group14project.domain.CourseSession;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseSessionRepository extends CrudRepository<CourseSession, String> {
}
