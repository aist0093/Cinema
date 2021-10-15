package com.example.demo.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "location", schema = "demo31")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id", nullable = false, length = 11)
    private int location;
    @Basic
    @Column(name = "district", nullable = false, length = 25)
    private String district;
    @Basic
    @Column(name = "name", nullable = false, length = 25)
    private String name;

    public Location(int locationId, String district, String name) {
        this.location = locationId;
        this.district = district;
        this.name = name;
    }

    public int getLocationId() {
        return location;
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

    @Override
    public String toString() {
        return "Location{" +
                "locationId=" + location +
                ", district='" + district + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
