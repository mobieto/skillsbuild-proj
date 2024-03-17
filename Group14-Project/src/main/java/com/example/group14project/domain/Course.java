package com.example.group14project.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Course{
    @Id
    private String name;
    private String link;

    private String category;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Course(String name, String link, String category) {
        this.name = name;
        this.link = link;
        this.category = category;
    }

    public Course() {

    }

    public String getName() {
        return name;
    }
    public String getLink() {
        return link;
    }
    public String getCategory() {
        return category;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setLink(String link) {
        this.link = link;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}