package com.example.demo.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Viewing {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int viewingId;
    private int auditoriumId;
    private int movieId;
    private Date dateTime;
    private float price;


}
