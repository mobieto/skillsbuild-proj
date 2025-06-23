package com.example.group14project.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Badge {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String name;

    private String description;

    @ManyToMany(mappedBy = "badges")
    private List<SkillsBuildUser> usersAwarded;

    private String owner;

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

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Badge{" +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
