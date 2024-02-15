package com.example.group14project.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class SkillsBuildUser {
    @Id
    private String name;

    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Badge> badges;

    public void awardBadge(Badge badge) {
        if (this.badges == null) this.badges = new ArrayList<Badge>();

        this.badges.add(badge);
    }
}
