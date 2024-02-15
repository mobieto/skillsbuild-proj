package com.example.recordstarttime.model;

import java.time.Duration;
import java.time.LocalDateTime;

public class CourseSession {

    private String courseName;
    private LocalDateTime startTime;
    private LocalDateTime pauseTime;
    private Duration pausedDuration;

    // Constructors, getters, setters
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
            pauseTime = LocalDateTime.now();
        }
    }

    public void resume() {
        if (pauseTime != null) {
            pausedDuration = pausedDuration.plus(Duration.between(pauseTime, LocalDateTime.now()));
            pauseTime = null;
        }
    }

    public Duration getElapsedTime() {
        if (pauseTime != null) {
            return Duration.between(startTime, pauseTime);
        } else {
            return Duration.between(startTime, LocalDateTime.now()).minus(pausedDuration);
        }
    }

    public String getFormattedElapsedTime() {
        Duration elapsedTime;
        if (pauseTime != null) {
            elapsedTime = Duration.between(startTime, pauseTime);
        } else {
            elapsedTime = Duration.between(startTime, LocalDateTime.now()).minus(pausedDuration);
        }

        long hours = elapsedTime.toHours();
        long minutes = elapsedTime.toMinutesPart();
        long seconds = elapsedTime.toSecondsPart();

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    public void reset() {
        startTime = null;
        pauseTime = null;
        pausedDuration = Duration.ZERO;
    }
}
