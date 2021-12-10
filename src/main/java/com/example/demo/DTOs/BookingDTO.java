package com.example.demo.DTOs;

import com.example.demo.Entities.Booking;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookingDTO {

    Integer bookingId;
    ViewingDTO viewing;
    String email;

    public BookingDTO(Booking booking) {
        this.bookingId = booking.getBooking();
        this.viewing = new ViewingDTO(booking.getViewing());
        this.email = booking.getEmail();
    }

    public ViewingDTO getViewing() {
        return viewing;
    }
}
