package com.example.shoplist.Model;

public class Item {

    private String name;

    private String description;

    private boolean done;

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

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "ITEM: " + name + " " + description + " " +done;
    }
}
