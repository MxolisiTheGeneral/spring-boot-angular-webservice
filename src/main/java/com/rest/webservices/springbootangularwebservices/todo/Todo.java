package com.rest.webservices.springbootangularwebservices.todo;

import java.util.Date;

public class Todo {

     private long id;
     private String username;
     private String description;
     private Date targetedDate;
     private boolean isDone;

     public Todo(){}

    public Todo(long id, String username, String description, Date targetedDate, boolean isDone) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.targetedDate = targetedDate;
        this.isDone = isDone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTargetedDate() {
        return targetedDate;
    }

    public void setTargetedDate(Date targetedDate) {
        this.targetedDate = targetedDate;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", description='" + description + '\'' +
                ", targetedDate=" + targetedDate +
                ", isDone=" + isDone +
                '}';
    }
}
