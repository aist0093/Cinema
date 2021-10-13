package com.example.demo.Entities;

import javax.persistence.*;

@Entity
@Table(name="movie", schema="demo31")
public class Movie {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int movieId;
    private String imdbId;
    private int ageRequirement;

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
}
