package com.example.group14project.domain;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class CourseSession {
    private String courseName;
    private LocalDateTime startTime;
    private Long pauseTime;
    private Duration pausedDuration;

    public CourseSession() {
        this.pausedDuration = Duration.ZERO;
    }

    public CourseSession(String courseName, LocalDateTime startTime) {
        this.courseName = courseName;
        this.startTime = startTime;
        this.pauseTime = null;
        this.pausedDuration = Duration.ZERO;
    }

    public void start() {
        this.startTime = LocalDateTime.now();
    }

    public void pause() {
        if (pauseTime == null) {
            pauseTime = System.currentTimeMillis();
            System.out.println("Session paused at: " + Instant.ofEpochMilli(pauseTime));
        } else {
            System.out.println("Session is already paused.");
        }

    }

    public void resume() {
        if (pauseTime != null) {
            long resumeTime = System.currentTimeMillis();
            System.out.println("Session resumed at: " + Instant.ofEpochMilli(resumeTime));
            pausedDuration = pausedDuration.plusMillis(resumeTime - pauseTime);
            pauseTime = null;
        }
    }

    public Duration getElapsedTime() {
        if (pauseTime != null) {
            LocalDateTime pauseDateTime = Instant.ofEpochMilli(pauseTime).atZone(ZoneId.systemDefault()).toLocalDateTime();
            return Duration.between(startTime, pauseDateTime).plus(pausedDuration);
        } else {
            return Duration.between(startTime, LocalDateTime.now()).minus(pausedDuration);
        }
    }

    public String getFormattedElapsedTime() {
        Duration elapsedTime = calculateElapsedTime();

        long hours = elapsedTime.toHours();
        long minutes = elapsedTime.toMinutesPart();
        long seconds = elapsedTime.toSecondsPart();

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    private Duration calculateElapsedTime() {
        if (pauseTime != null) {
            LocalDateTime pauseDateTime = Instant.ofEpochMilli(pauseTime).atZone(ZoneId.systemDefault()).toLocalDateTime();
            return Duration.between(startTime, pauseDateTime).plus(pausedDuration);
        } else {
            return Duration.between(startTime, LocalDateTime.now()).minus(pausedDuration);
        }
    }

    public void reset() {
        startTime = null;
        pauseTime = null;
        pausedDuration = Duration.ZERO;
    }
}