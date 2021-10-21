package com.example.demo.DTOs;

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
    MovieDTO movie;
    Integer viewingId;

    public ViewingDTO(Viewing viewing) {
        this.dateTime = viewing.getDateTime();
        this.movie = new MovieDTO(viewing.getMovie());
        this.viewingId = viewing.getViewingId();
    }
}
