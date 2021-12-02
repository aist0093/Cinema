package com.example.demo.DTOs;

import com.example.demo.Entities.Location;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LocationDTO {

    String name;
    Integer id;

    public LocationDTO(String name, int id){
        this.name = name;
        this.id = id;
    }

    public LocationDTO(Location location){
        this.name = location.getName();
        this.id = location.getLocationId();
    }
}
