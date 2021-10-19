package com.example.demo.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "movie", schema = "demo31")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id", nullable = false, length = 11)
    private int movie;
    @Basic
    @Column(name = "imdb_id", nullable = false, length = 10)
    private String imdbId;
    @Basic
    @Column(name = "age_req", nullable = false, length = 2)
    private int ageRequirement;
    @Basic
    @Column(name = "title", nullable = false, length = 125)
    private String title;
    @Basic
    @Column(name = "rate", nullable = false, length = 125)
    private String rate;
    @Basic
    @Column(name = "duration", nullable = false, length = 125)
    private String duration;
    @Basic
    @Column(name = "actors", nullable = false, length = 250)
    private String actors;
    @Basic
    @Column(name = "image", nullable = false, length = 250)
    private String image;
    @Basic
    @Column(name = "description", nullable = false, length = 500)
    private String description;



    public Movie(int movieId, String imdbId, int ageRequirement) {
        this.movie = movieId;
        this.imdbId = imdbId;
        this.ageRequirement = ageRequirement;
    }

    public Movie(Integer movie_id, Integer age_req, String imdb_id, String actors, String image, String duration, String rate, String title, String video, String description) {

    }

    public int getMovie() {
        return movie;
    }

    public void setMovie(int movie) {
        this.movie = movie;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public int getAgeRequirement() {
        return ageRequirement;
    }

    public void setAgeRequirement(int ageRequirement) {
        this.ageRequirement = ageRequirement;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }


    @Override
    public String toString() {
        return "Movie{" +
                "movie=" + movie +
                ", imdbId='" + imdbId + '\'' +
                ", ageRequirement=" + ageRequirement +
                ", title='" + title + '\'' +
                ", rate='" + rate + '\'' +
                ", duration='" + duration + '\'' +
                ", actors='" + actors + '\'' +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
