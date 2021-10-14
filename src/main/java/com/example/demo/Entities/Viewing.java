package com.example.demo.Entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="viewing", schema="demo31")
public class Viewing {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int viewingId;
    private int auditoriumId;
    private int movieId;
    private Date dateTime;
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
