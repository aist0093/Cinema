package com.example.demo.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "seat", schema = "demo31")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seat_id", nullable = false, length = 11)
    private int seat;
    @ManyToOne
    @JoinColumn(name="viewing_id", nullable = false)
    private Viewing viewingId;
    @Basic
    @Column(name = "row", nullable = false, length = 2)
    private int row;
    @Basic
    @Column(name = "seat_num", nullable = false, length = 2)
    private int seatNumber;

    public Seat(int seatId, Viewing viewingId, int row, int seatNumber) {
        this.seat = seatId;
        this.viewingId = viewingId;
        this.row = row;
        this.seatNumber = seatNumber;
    }

    public Seat() {

    }

    public int getSeatId() {
        return seat;
    }

    public Viewing getViewingId() {
        return viewingId;
    }

    public void setViewingId(Viewing viewingId) {
        this.viewingId = viewingId;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "seatId=" + seat +
                ", viewingId=" + viewingId +
                ", row=" + row +
                ", seatNumber=" + seatNumber +
                '}';
    }
}
