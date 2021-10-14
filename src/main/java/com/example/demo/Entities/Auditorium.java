package com.example.demo.Entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Setter
@Getter
@Entity
@Table(name="auditorium", schema="demo31")
public class Auditorium {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "auditoriumId", nullable = false, length = 11)      //declaring length of tables
    private int auditoriumId;                                          //creating tables
    @Basic
    @Column(name ="locationId", nullable = false, length = 11)
    private int locationId;
    @Basic
    @Column(name = "name", nullable = false, length = 2)
    private String name;
    @Basic
    @Column(name = "rowNumber", nullable = false, length = 2)
    private int rowNumber;
    @Basic
    @Column(name = "aisleNumber", nullable = false, length = 2)
    private int aisleNumber;


    public int getAuditoriumId() {
        return auditoriumId;
    }


    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public int getAisleNumber() {
        return aisleNumber;
    }

    public void setAisleNumber(int aisleNumber) {
        this.aisleNumber = aisleNumber;
    }
}
