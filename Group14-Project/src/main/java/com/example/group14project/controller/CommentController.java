package com.example.group14project.controller;

import com.example.group14project.domain.CourseComment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommentController {
    @GetMapping("/comment")
    public String showCommentForm(Model model) {
        model.addAttribute("comment", new CourseComment());
        return "commentForm";
    }

    @PostMapping("/comment")
    public String submitComment(CourseComment comment, Model model) {
        model.addAttribute("submittedComment", comment);

        return "commentForm";
    }
}
