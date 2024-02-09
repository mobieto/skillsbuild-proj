package leaderboard.model;

public class Players {
    private int id;
    private String name;
    private int coursesCompleted;

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

    public int getCoursesCompleted() {
        return coursesCompleted;
    }

    public void setCoursesCompleted(int coursesCompleted) {
        this.coursesCompleted = coursesCompleted;
    }

    @Override
    public String toString() {
        return "Players{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coursesCompleted=" + coursesCompleted +
                '}';
    }
}
