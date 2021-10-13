package com.example.demo.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Seat {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int seatId;
    private int viewingId;
    private int row;
    private int seatNumber;

}
