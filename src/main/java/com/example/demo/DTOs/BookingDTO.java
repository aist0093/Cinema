package com.example.demo.DTOs;

import com.example.demo.Entities.Auditorium;
import com.example.demo.Entities.Movie;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookingDTO {

    Movie movie;
    Auditorium auditorium;
    Date dateTime;


}
