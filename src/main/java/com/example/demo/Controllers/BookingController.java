package com.example.demo.Controllers;

import com.example.demo.DTOs.BookingDTO;
import com.example.demo.Services.BookingService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookingController {
    BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    // delete a booking
    @DeleteMapping("/booking/")
    public void cancelBooking(@RequestParam String email, @RequestParam int bookingId) {
        bookingService.deleteBooking(email, bookingId);
    }


    //create a booking
    @PostMapping("/booking")
    public BookingDTO createBooking(@RequestBody ObjectNode body) {
        return bookingService.createBooking(body.get("title").asText(), body.get("name").asText(), body.get("dateTime").asText(),
                body.get("email").asText(), body.get("row").asInt(), body.get("seat_num").asInt());
    }

    //update a booking
    @PutMapping("/booking/{id}")
    public BookingDTO updateRowAndSeat(@RequestBody ObjectNode body, @PathVariable int id) {
        return bookingService.editBookingSeats(id, body.get("email").asText(), body.get("row").asInt(), body.get("seat_num").asInt());
    }

}