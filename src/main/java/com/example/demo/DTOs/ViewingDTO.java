package com.example.demo.DTOs;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

public interface ViewingDTO {

     Integer getMovieId();
     Date getDateTime();

}
