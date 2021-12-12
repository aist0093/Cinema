package com.example.demo.DTOs;

import com.example.demo.Entities.Movie;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovieDTO {

    String title;
    String description;
    String duration;
    String ageRequirement;
    String actors;
    String poster;
    String rating;

    public MovieDTO(Movie m){
        this.title = m.getTitle();
        this.description = m.getDescription();
        this.duration = m.getDuration();
        this.ageRequirement = String.valueOf(m.getAgeRequirement());
        this.actors = m.getActors();
        this.poster = m.getImage();
        this.rating = m.getRate();

    }
}
