package com.example.group14project.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.Duration;

@Entity
public class Course {
    @Id
    private String name;
    private String link;
    private String category;
    private String status;
    private String percentageCompleted;

    public String getPercentageCompleted() {
        return percentageCompleted;
    }

    public void setPercentageCompleted(String percentageCompleted) {
        this.percentageCompleted = percentageCompleted;
    }
    private String completedTime;

    public Course(String name, String link, String category) {
        this.name = name;
        this.link = link;
        this.category = category;
        this.status = "Not Started"; // Default status
        this.completedTime = completedTime;
    }

    public Course() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCompletedTime() {
        return completedTime;
    }

    public void setCompletedTime(String completedTime) {
        this.completedTime = completedTime;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", link='" + link + '\'' +
                ", category='" + category + '\'' +
                ", status='" + status + '\'' +
                ", completedTime=" + completedTime +
                '}';
    }
}