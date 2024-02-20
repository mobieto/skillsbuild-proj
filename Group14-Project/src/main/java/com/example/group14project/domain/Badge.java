package com.example.group14project.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Badge {
    @Id
    private String name;

    private String description;

    @ManyToMany(mappedBy = "badges")
    private List<SkillsBuildUser> usersAwarded;


    public Badge(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Badge() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Badge{" +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
