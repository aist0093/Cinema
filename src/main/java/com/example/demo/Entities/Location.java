package com.example.demo.Entities;

import javax.persistence.*;

@Entity
@Table(name="location", schema="demo31")
public class Location {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int locationId;
    private String district;
    private String name;

    public int getLocationId() {
        return locationId;
    }


    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
