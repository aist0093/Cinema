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
     int movieId;
     Date dateTime;

}
