package com.example.group14project.domain;

import jakarta.persistence.*;

import java.util.*;

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
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Course> courseCompletedList;

    @OneToMany(cascade = CascadeType.ALL)
    private List<CourseSession> activeCourseList;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Map<String, CourseSession> activeSessions = new HashMap<>();

    @Column(length = 110000000)
    private String profilePictureBase64;

    private String alias;
    private String bio;

    private byte[] profilePicture;

    public List<CourseSession> getActiveCourseList() {
        return activeCourseList;
    }

    public void addActiveCourse(CourseSession courseSession) {
        this.activeCourseList.add(courseSession);
    }

    public void removeActiveCourse(CourseSession courseSession) {
        this.activeCourseList.remove(courseSession);
    }

    public void removeActiveCourse(String courseSessionName) {
        for(CourseSession courseSession : this.activeCourseList) {
            if (Objects.equals(courseSession.getCourseName(), courseSessionName)) {
                removeActiveCourse(courseSession);
                return;
            }
        }
    }

    public CourseSession getActiveCourse(String courseSessionName) {
        for(CourseSession courseSession : this.activeCourseList) {
            if (Objects.equals(courseSession.getCourseName(), courseSessionName)) {
                return courseSession;
            }
        }
        return null;
    }

    public int getCoursesCompleted() {
        return coursesCompleted;
    }
    public void setCoursesCompleted(int coursesCompleted) {
        this.coursesCompleted = coursesCompleted;
    }
    public Leaderboard getLeaderboard() {return leaderboard;}
    public void setLeaderboard(Leaderboard leaderboard) {this.leaderboard = leaderboard;}

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

    private int totalExp;

    public SkillsBuildUser() {
        this.totalExp = 0;
    }

    public void addExp(int exp) {
        this.totalExp += exp;
    }

    public int getCurrentLevel() {
        return 1 + totalExp / 500;
    }

    public int getTotalExp() {
        return totalExp;
    }

    public void setTotalExp(int totalExp) {
        this.totalExp = totalExp;
    }

    public Map<String, CourseSession> getActiveSessions() {
        return activeSessions;
    }

    public void setActiveSessions(Map<String, CourseSession> activeSessions) {
        this.activeSessions = activeSessions;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getProfilePictureBase64() {
        return profilePictureBase64;
    }

    public void setProfilePictureBase64(String profilePictureBase64) {
        this.profilePictureBase64 = profilePictureBase64;
    }

}
