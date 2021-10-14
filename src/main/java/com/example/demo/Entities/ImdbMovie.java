package com.example.demo.Entities;

public class ImdbMovie {
    private String title;
    private String description;
    private String rating;
    private String duration;
    private String actors;

    public ImdbMovie(String title, String description, String rating, String duration, String actors) {
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.duration = duration;
        this.actors = actors;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getRating() {
        return rating;
    }

    public String getDuration() {
        return duration;
    }

    public String getActors() {
        return actors;
    }
}
