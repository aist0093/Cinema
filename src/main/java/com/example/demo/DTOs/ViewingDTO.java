package com.example.demo.DTOs;

import com.example.demo.Entities.Movie;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

public interface ViewingDTO {


     Movie getMovie();
     Date getDateTime();

}
