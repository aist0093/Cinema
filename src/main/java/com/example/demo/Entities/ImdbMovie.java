package com.example.demo.Entities;

public class ImdbMovie {
    private final String title;
    private final String description;
    private final String rating;
    private final String duration;
    private final String actors;
    private final String image;
    private final String video;

    public ImdbMovie(String title, String description, String rating, String duration, String actors, String image, String video) {
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.duration = duration;
        this.actors = actors;
        this.image = image;
        this.video = video;
    }

    @Override
    public String toString() {
        return "ImdbMovie{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", rating='" + rating + '\'' +
                ", duration='" + duration + '\'' +
                ", actors='" + actors + '\'' +
                ", image='" + image + '\'' +
                ", video='" + video + '\'' +
                '}';
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


    public String getImage() {
        return image;
    }

    public String getVideo() {
        return video;
    }
}
