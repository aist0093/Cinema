package com.example.demo.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Getter
@Setter
@Entity
@Table(name="viewing", schema="demo31")
public class Viewing {
    @Id

    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "viewing_id", nullable = false, length = 11)
    private int viewingId;
    @Basic
    @Column(name = "auditorium_id", nullable = false, length = 11)
    private int auditoriumId;
    @Basic
    @Column(name = "movie_id", nullable = false, length = 11)
    private int movieId;
    @Basic
    @Column(name = "date_time",nullable = false)
    private Date dateTime;
    @Basic
    @Column(name = "price", nullable = false)
    private float price;

    public int getViewingId() {
        return viewingId;
    }

    public int getAuditoriumId() {
        return auditoriumId;
    }

    public void setAuditoriumId(int auditoriumId) {
        this.auditoriumId = auditoriumId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
