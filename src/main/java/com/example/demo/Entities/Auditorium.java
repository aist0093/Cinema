package com.example.demo.Entities;


import javax.persistence.*;


@Entity
@Table(name="auditorium", schema="demo31")
public class Auditorium {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int auditoriumId;
    private int locationId;
    private String name;
    private int rowNumber;
    private int aisleNumber;




}
