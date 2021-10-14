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
    @Column(name = "viewingId", nullable = false, length = 11)
    private int viewingId;
    @Column(name = "auditoriumId", nullable = false, length = 11)
    @ManyToOne
    @JoinColumn(name ="auditorium_id", referencedColumnName = "auditorium_id")
    private Auditorium auditoriumId;
    @Column(name = "movieId", nullable = false, length = 11)
    @ManyToOne
    @JoinColumn(name ="movie_id", referencedColumnName = "movie_id")
    private Movie movieId;
    @Basic
    @Column(name = "dateTime",nullable = false)
    private Date dateTime;
    @Basic
    @Column(name = "price", nullable = false)
    private float price;

    public int getViewingId() {
        return viewingId;
    }

    public Auditorium getAuditoriumId() {
        return auditoriumId;
    }

    public void setAuditoriumId(Auditorium auditoriumId) {
        this.auditoriumId = auditoriumId;
    }

    public Movie getMovieId() {
        return movieId;
    }

    public void setMovieId(Movie movieId) {
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
