package org.example;

public class TODO {

    private String userId;
    private int id;
    private String title;
    private boolean completed;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean getCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "TODO{" +
                "userId='" + userId + '\'' +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }
}
