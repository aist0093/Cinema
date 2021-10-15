package com.example.demo.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "viewing", schema = "demo31")
public class Viewing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "viewing_id", nullable = false, length = 11)
    private int viewingId;
    @ManyToOne
    @JoinColumn(name="auditorium_id", nullable = false)
    private Auditorium auditorium;
    @ManyToOne
    @JoinColumn(name="movie_id", nullable = false)
    private Movie movie;
    @Basic
    @Column(name = "date_time", nullable = false)
    private Date dateTime;
    @Basic
    @Column(name = "price", nullable = false)
    private float price;

    public Viewing(Auditorium auditorium, Movie movie, Date dateTime, float price) {
        this.auditorium = auditorium;
        this.movie = movie;
        this.dateTime = dateTime;
        this.price = price;
    }

    public int getViewingId() {
        return viewingId;
    }

    public Auditorium getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(Auditorium auditorium) {
        this.auditorium = auditorium;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public Viewing setDateTime(Date dateTime) {
        this.dateTime = dateTime;
        return this;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
