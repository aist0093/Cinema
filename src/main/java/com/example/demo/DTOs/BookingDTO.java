package com.example.demo.DTOs;

import com.example.demo.Entities.Booking;
import com.example.demo.Entities.Seat;
import com.example.demo.Entities.Viewing;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookingDTO {

//    Integer booking;
    ViewingDTO viewing;
    String email;

    public BookingDTO(Booking booking) {
        this.viewing = new ViewingDTO(booking.getViewing());
        this.email = booking.getEmail();
    }

    public ViewingDTO getViewing() {
        return viewing;
    }
}
