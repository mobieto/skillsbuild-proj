package com.example.group14project.controller;

import com.example.group14project.domain.Leaderboard;
import com.example.group14project.domain.SkillsBuildUser;
import com.example.group14project.domain.UserRole;
import com.example.group14project.repo.LeaderboardRepository;
import com.example.group14project.repo.SkillsBuildUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class AuthenticationController {

    @Autowired
    private SkillsBuildUserRepository skillsBuildUserRepository;

    @Autowired
    private LeaderboardRepository leaderboardRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping(value = "/success-login")
    public String successLogin(Principal principal) {
        SkillsBuildUser user = skillsBuildUserRepository.findByName(principal.getName());
        if (user.getRoles().isEmpty()) {
            return "security/denied";
        }
        return "redirect:/dashboard";
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

    @GetMapping("/register-form")
    public String registerForm(Model model) {
        model.addAttribute("user", new SkillsBuildUser());
        return "security/register";
    }

    @PostMapping("/register-form")
    public String register(@ModelAttribute SkillsBuildUser skillsBuildUser) {
        UserRole role = new UserRole("default");
        skillsBuildUser.addRole(role);
        skillsBuildUser.setPassword(passwordEncoder.encode(skillsBuildUser.getPassword()));
        skillsBuildUser.setCoursesCompleted(0);
        skillsBuildUserRepository.save(skillsBuildUser);
        Leaderboard leaderboard = leaderboardRepository.findById(1);
        leaderboard.getPlayers().add(skillsBuildUser);
        leaderboardRepository.save(leaderboard);
        return "security/login";
    }

}
