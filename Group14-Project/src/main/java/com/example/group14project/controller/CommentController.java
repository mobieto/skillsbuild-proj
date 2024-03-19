package com.example.group14project.controller;

import com.example.group14project.domain.CourseComment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CommentController {

    private List<CourseComment> submittedComments = new ArrayList<>();

    @GetMapping("/comment")
    public String showCommentForm(Model model) {
        model.addAttribute("submittedComments", submittedComments);
        return "commentForm";
    }

    @PostMapping("/comment")
    public String submitComment(CourseComment comment) {
        submittedComments.add(comment);
        return "redirect:/comment";
    }
}