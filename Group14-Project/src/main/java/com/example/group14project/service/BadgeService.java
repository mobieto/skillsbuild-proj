package com.example.group14project.service;

import com.example.group14project.domain.Badge;
import com.example.group14project.domain.SkillsBuildUser;
import com.example.group14project.repo.BadgeRepository;
import com.example.group14project.repo.SkillsBuildUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BadgeService {
    @Autowired
    private BadgeRepository badgeRepository;

    public void awardBadgeToUser(SkillsBuildUser user, Badge badge) {
        if (user.getBadges() == null) user.setBadges(new ArrayList<>());

        badge.setOwner(user.getName());
        user.getBadges().add(badge);

        badgeRepository.save(badge);
    }
}
