package com.example.group14project.domain;

import jakarta.persistence.*;

@Entity
public class Badge {
    @Id
    private int id;

    private String name;

    private String description;

    @ManyToOne
    private SkillsBuildUser owner;

    public Badge(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Badge() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public SkillsBuildUser getOwner() {
        return owner;
    }

    public void setOwner(SkillsBuildUser owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Badge{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
