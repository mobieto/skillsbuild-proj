package com.example.group14project.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class SkillsBuildUser {

    @Id
    private String name;
    private String password;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<UserRole> userRoles = new ArrayList<>();
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Badge> badges;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<SkillsBuildUser> friends;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<SkillsBuildUser> outgoingFriendRequests;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<SkillsBuildUser> incomingFriendRequests;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "leaderboard_id")
    private Leaderboard leaderboard;
    private int coursesCompleted;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Course> courseCompletedList;

    public int getCoursesCompleted() {
        return coursesCompleted;
    }
    public void setCoursesCompleted(int coursesCompleted) {
        this.coursesCompleted = coursesCompleted;
    }
    public Leaderboard getLeaderboard() {return leaderboard;}
    public void setLeaderboard(Leaderboard leaderboard) {this.leaderboard = leaderboard;}
    //end of leaderboard code

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<UserRole> getRoles() {
        return userRoles;
    }

    public void setRoles(List<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    public void addRole(UserRole role) {
        this.userRoles.add(role);
    }

    public List<SkillsBuildUser> getFriends() {
        return friends;
    }

    public void setFriends(List<SkillsBuildUser> friends) {
        this.friends = friends;
    }

    public List<SkillsBuildUser> getOutgoingFriendRequests() {
        return outgoingFriendRequests;
    }

    public void setOutgoingFriendRequests(List<SkillsBuildUser> outgoingFriendRequests) {
        this.outgoingFriendRequests = outgoingFriendRequests;
    }

    public List<SkillsBuildUser> getIncomingFriendRequests() {
        return incomingFriendRequests;
    }

    public void setIncomingFriendRequests(List<SkillsBuildUser> incomingFriendRequests) {
        this.incomingFriendRequests = incomingFriendRequests;
    }

    public List<Badge> getBadges() {
        return badges;
    }

    public void setBadges(List<Badge> badges) {
        this.badges = badges;
    }

    public List<Course> getCourseCompletedList() {
        return courseCompletedList;
    }

    public void setCourseCompletedList(List<Course> courseCompletedList) {
        this.courseCompletedList = courseCompletedList;
    }
}
