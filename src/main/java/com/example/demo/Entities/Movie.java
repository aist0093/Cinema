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
    @Column(name = "movieId", nullable = false, length = 11)
    private int movieId;
    @Basic
    @Column(name = "imdbId", nullable = false, length = 10)
    private String imdbId;
    @Basic
    @Column(name = "ageRequirement", nullable = false, length = 2)
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
