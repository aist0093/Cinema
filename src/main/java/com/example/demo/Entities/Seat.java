package com.example.demo.Entities;

import javax.persistence.*;

@Entity
@Table(name="seat", schema="demo31")
public class Seat {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int seatId;
    private int viewingId;
    private int row;
    private int seatNumber;

    public int getSeatId() {
        return seatId;
    }

    public int getViewingId() {
        return viewingId;
    }

    public void setViewingId(int viewingId) {
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
}
