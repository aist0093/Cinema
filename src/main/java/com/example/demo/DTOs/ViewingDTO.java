package com.example.demo.DTOs;
import com.example.demo.Entities.Viewing;
import java.util.Date;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
//     getters
//     setters
//     constructors
   
}
