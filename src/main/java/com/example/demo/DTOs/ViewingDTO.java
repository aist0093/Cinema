package com.example.demo.DTOs;

import com.example.demo.Entities.Auditorium;
import com.example.demo.Entities.ImdbMovie;
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

    Date dateTime;
    Movie movieId;
    String title;

    public ViewingDTO(Movie movieId, Date dateTime) {
        this.movieId = movieId;
        this.dateTime = dateTime;
    }

    public ViewingDTO(Viewing viewing) {
        this.dateTime = viewing.getDateTime();
        this.movieId = viewing.getMovie();
    }

    public void setTitle(String title){
        this.title = title;
    }
}
