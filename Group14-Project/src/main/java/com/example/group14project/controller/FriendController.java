package com.example.group14project.controller;

import com.example.group14project.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
public class FriendController {
    @Autowired
    private FriendService friendService;

    @PostMapping("/sendFriendRequest")
    private String sendFriendRequest(@RequestParam String username, @RequestParam(required = false) String redirectTo, Principal principal, RedirectAttributes redirectAttributes) {
        String resultMessage = friendService.sendFriendRequest(principal.getName(), username);

        redirectAttributes.addFlashAttribute("friendRequestResult", resultMessage);

        return "redirect:/user" + (redirectTo != null ? "s/%s".formatted(redirectTo) : "");
    }

    @PostMapping("/removeFriend")
    private String removeFriend(@RequestParam String username, @RequestParam(required = false) String redirectTo, Principal principal, RedirectAttributes redirectAttributes) {
        String resultMessage = friendService.removeFriend(principal.getName(), username);

        redirectAttributes.addFlashAttribute("removeFriendResult", resultMessage);

        return "redirect:/user" + (redirectTo != null ? "s/%s".formatted(redirectTo) : "");
    }

    @PostMapping("/acceptFriendRequest")
    private String acceptFriendRequest(@RequestParam String username, @RequestParam(required = false) String redirectTo, Principal principal, RedirectAttributes redirectAttributes) {
        String resultMessage = friendService.acceptFriendRequest(username, principal.getName());

        redirectAttributes.addFlashAttribute("acceptFriendRequestResult", resultMessage);

        return "redirect:/user" + (redirectTo != null ? "s/%s".formatted(redirectTo) : "");
    }

    @PostMapping("/removeFriendRequest")
    private String removeFriendRequest(@RequestParam String username, @RequestParam(required = false) String redirectTo, Principal principal, RedirectAttributes redirectAttributes) {
        String resultMessage = friendService.removeFriendRequest(principal.getName(), username);

        redirectAttributes.addFlashAttribute("removeFriendRequestResult", resultMessage);

        return "redirect:/user" + (redirectTo != null ? "s/%s".formatted(redirectTo) : "");
    }
}
