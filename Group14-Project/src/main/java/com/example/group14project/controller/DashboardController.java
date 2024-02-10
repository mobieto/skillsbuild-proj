package com.example.group14project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DashboardController {
    @GetMapping("/Dashboard")
    public String dashboard() {
        return "home";
    }
}
