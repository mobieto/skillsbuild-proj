package com.example.group14project.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class SkillsBuildUser {
<<<<<<< HEAD
    @Id
    private String name;

    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Badge> badges;

    public void awardBadge(Badge badge) {
        if (this.badges == null) this.badges = new ArrayList<Badge>();

        this.badges.add(badge);
=======

    @Id
    private String name;
    private String password;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<UserRole> userRoles = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<UserRole> getRoles() {
        return userRoles;
    }

    public void setRoles(List<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    public void addRole(UserRole role) {
        this.userRoles.add(role);
>>>>>>> origin/main
    }
}
