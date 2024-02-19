package com.example.group14project.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class UserRole {

    @Id
    private String name;

    @ManyToMany(mappedBy = "userRoles")
    private List<SkillsBuildUser> users;

    public UserRole() {};

    public UserRole(String name) {
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
