package com.example.group14project.controller;

import com.example.group14project.domain.CourseComment;
import com.example.group14project.repo.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import com.example.group14project.domain.Course;

@Controller
public class CommentController {

    private List<CourseComment> submittedComments = new ArrayList<>();

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/comment")
    public String showCommentForm(Model model) {
        List<Course> courses = courseRepository.findAll();
        model.addAttribute("courses", courses);
        model.addAttribute("submittedComments", submittedComments);
        return "commentForm";
    }

    @PostMapping("/comment")
    public String submitComment(CourseComment comment) {
        submittedComments.add(comment);
        return "redirect:/comment";
    }
}