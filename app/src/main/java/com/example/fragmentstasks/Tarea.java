package com.example.fragmentstasks;

import java.io.Serializable;

public class Tarea implements Serializable {
    private String title, description;

    public Tarea(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return title + " - " + description;
    }
}
