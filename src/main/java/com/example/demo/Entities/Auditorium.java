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
