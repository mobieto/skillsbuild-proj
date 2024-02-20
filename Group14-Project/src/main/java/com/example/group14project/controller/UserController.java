package com.example.group14project.controller;

import com.example.group14project.domain.SkillsBuildUser;
import com.example.group14project.repo.SkillsBuildUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class UserController {

    @Autowired
    SkillsBuildUserRepository repository;

    @GetMapping("/user")
    public String user(Model model, Principal principal) {
        SkillsBuildUser user = repository.findByName(principal.getName());
        model.addAttribute("user", user);
        return "user";
    }
}
