package com.example.demo.Entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Auditorium {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int auditoriumId;
    private int locationId;
    private String name;
    private int rowNumber;
    private int aisleNumber;

}
