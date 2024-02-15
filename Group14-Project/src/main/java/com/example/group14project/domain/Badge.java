package com.example.group14project.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Badge {
    @Id
    private int id;

    private String name;

    private String description;

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

    @Override
    public String toString() {
        return "Badge{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}