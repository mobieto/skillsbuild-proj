package com.example.group14project.repo;


import com.example.group14project.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    Course findByName(String name);
    List<Course> findByStatus(String status);
}