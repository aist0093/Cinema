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

     int viewingId;
     int auditoriumId;
     int movieId;
     Date dateTime;
     float price;

     public ViewingDTO(Integer movie_id, Integer auditorium_id, Date date_time, float price) {
          this.movieId = movie_id;
          this.auditoriumId = auditorium_id;
          this.dateTime = date_time;
          this.price = price;
     }
}
