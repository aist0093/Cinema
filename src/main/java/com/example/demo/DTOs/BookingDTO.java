package com.example.demo.DTOs;

import com.example.demo.Entities.Booking;
import com.example.demo.Entities.Viewing;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookingDTO {

    Integer booking;
    Viewing viewing;
    String email;

    public BookingDTO(Booking booking) {
        this.viewing = booking.getViewing();
        this.email = booking.getEmail();
    }

}
