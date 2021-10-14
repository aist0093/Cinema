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
    @Column(name = "auditorium_id", nullable = false, length = 11)      //declaring length of tables
    private int auditoriumId;                                          //creating tables

    @Column(name ="location_id", nullable = false, length = 11)
    @ManyToOne
    @JoinColumn(name ="location_id", referencedColumnName = "location_id")
    private Location locationId;
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

    public Location getLocationId() {
        return locationId;
    }

    public void setLocationId(Location locationId) {
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
