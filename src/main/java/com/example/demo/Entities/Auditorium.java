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
    @Basic
    @Column(name ="location_id", nullable = false, length = 11)
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "location_id")
    private int locationId;
    @Basic
    @Column(name = "name", nullable = false, length = 2)
    private String name;
    @Basic
    @Column(name = "row_num", nullable = false, length = 2)
    private int rowNumber;
    @Basic
    @Column(name = "aisle_num", nullable = false, length = 2)
    private int aisleNumber;

    public Auditorium(int auditoriumId, int locationId, String name, int rowNumber, int aisleNumber) {
        this.auditoriumId = auditoriumId;
        this.locationId = locationId;
        this.name = name;
        this.rowNumber = rowNumber;
        this.aisleNumber = aisleNumber;
    }

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

    @Override
    public String toString() {
        return "Auditorium{" +
                "auditoriumId=" + auditoriumId +
                ", locationId=" + locationId +
                ", name='" + name + '\'' +
                ", rowNumber=" + rowNumber +
                ", aisleNumber=" + aisleNumber +
                '}';
    }
}
