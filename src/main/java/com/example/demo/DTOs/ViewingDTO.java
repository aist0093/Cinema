package com.example.demo.DTOs;

import com.example.demo.Entities.Auditorium;
import com.example.demo.Entities.Movie;
import com.example.demo.Entities.Viewing;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ViewingDTO {

    int viewingId;
    Auditorium auditoriumId;
    Movie movieId;
    Date dateTime;
    float price;

    public ViewingDTO(Auditorium auditoriumId, Movie movieId, Date dateTime, float price) {
        this.auditoriumId = auditoriumId;
        this.movieId = movieId;
        this.dateTime = dateTime;
        this.price = price;
    }

    public ViewingDTO(Viewing viewing) {
        this.auditoriumId = viewing.getAuditorium();
        this.dateTime = viewing.getDateTime();
        this.price = viewing.getPrice();
    }
}
