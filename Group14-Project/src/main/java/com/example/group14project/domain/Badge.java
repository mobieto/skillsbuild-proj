package com.example.group14project.domain;

import jakarta.persistence.*;

@Entity
public class Badge {
    @Id
    private String name;

    private String description;

    @OneToOne
    private SkillsBuildUser owner;

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

    public SkillsBuildUser getOwner() {
        return owner;
    }

    public void setOwner(SkillsBuildUser owner) {
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
