package com.example.demo.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name="movie", schema="demo31")
public class Movie {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "movie_id", nullable = false, length = 11)
    private int movieId;
    @Basic
    @Column(name = "imdb_id", nullable = false, length = 10)
    private String imdbId;
    @Basic
    @Column(name = "age_req", nullable = false, length = 2)
    private int ageRequirement;

    public Movie(int movieId, String imdbId, int ageRequirement) {
        this.movieId = movieId;
        this.imdbId = imdbId;
        this.ageRequirement = ageRequirement;
    }

    public Movie() {

    }

    public int getMovieId() {
        return movieId;
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
                "movieId=" + movieId +
                ", imdbId='" + imdbId + '\'' +
                ", ageRequirement=" + ageRequirement +
                '}';
    }
}
