package com.example.demo.DTOs;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@EqualsAndHashCode
@Setter
@Getter
@NoArgsConstructor
public class ViewingDTO {

     int movieId;
     Date dateTime;

     public ViewingDTO(int movieId, Date dateTime) {
          this.movieId = movieId;
          this.dateTime = dateTime;
     }
}
