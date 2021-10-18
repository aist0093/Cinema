package com.example.demo.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
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
    @Column(name = "tittle", nullable = false, length = 125)
    private String tittle;
    @Basic
    @Column(name = "rate", nullable = false, length = 125)
    private String rate;
    @Basic
    @Column(name = "length", nullable = false, length = 20)
    private String length;
    @Basic
    @Column(name = "actors", nullable = false, length = 250)
    private String actors;
    @Basic
    @Column(name = "image", nullable = false, length = 250)
    private String image;
    @Basic
    @Column(name = "video", nullable = false, length = 250)
    private String video;


    public Movie(int movieId, String imdbId, int ageRequirement) {
        this.movie = movieId;
        this.imdbId = imdbId;
        this.ageRequirement = ageRequirement;
    }

    public Movie() {

    }

    public int getMovieId() {
        return movie;
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

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movie +
                ", imdbId='" + imdbId + '\'' +
                ", ageRequirement=" + ageRequirement +
                '}';
    }
}
