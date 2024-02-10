package com.example.group14project.controller;

import com.example.group14project.domain.SkillsBuildUser;
import com.example.group14project.repo.SkillsBuildUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class AuthenticationController {

    @Autowired
    private SkillsBuildUserRepository repo;

    @RequestMapping(value = "/success-login", method = RequestMethod.GET)
    public String successLogin(Principal principal) {
        SkillsBuildUser user = repo.findByName(principal.getName());
        if (user.getRoles().isEmpty()) {
            return "security/denied";
        }
        return "redirect:/Dashboard";
    }

    @GetMapping(value = "/login-form")
    public String loginForm(Model model) {
        return "security/login";
    }

    @RequestMapping(value = "/error-login")
    public String errorLogin() {
        return "security/login";
    }

    @RequestMapping(value = "/access-denied")
    public String accessDenied() {
        return "security/denied";
    }

}
