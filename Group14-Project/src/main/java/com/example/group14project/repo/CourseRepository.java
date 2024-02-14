package org.example.wstest.repo;


import org.example.wstest.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    Course findByName(String name);
}