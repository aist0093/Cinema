package com.example.demo.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "seat", schema = "demo31")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seat_id", nullable = false, length = 11)
    private int seat;
    @ManyToOne
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking;
    @Basic
    @Column(name = "row", nullable = false, length = 2)
    private int row;
    @Basic
    @Column(name = "seat_num", nullable = false, length = 2)
    private int seatNumber;

    public Seat(Booking booking, int row, int seatNumber) {
        this.booking = booking;
        this.row = row;
        this.seatNumber = seatNumber;
    }

    public int getSeatId() {
        return seat;
    }

    public Booking booking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
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
        return "{" + row + ", " + seatNumber + "}";
    }
}
