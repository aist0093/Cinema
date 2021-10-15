package com.example.demo.Entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
@Entity
@Table(name = "auditorium", schema = "demo31")
public class Auditorium {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auditorium_id", nullable = false, length = 11)      //declaring length of tables
    private int auditoriumId;                                          //creating tables
   @ManyToOne
    private Location location;
    @Basic
    @Column(name = "name", nullable = false, length = 2)
    private String name;
    @Basic
    @Column(name = "row_num", nullable = false, length = 2)
    private int rowNumber;
    @Basic
    @Column(name = "aisle_num", nullable = false, length = 2)
    private int aisleNumber;


    public int getAuditoriumId() {
        return auditoriumId;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
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
