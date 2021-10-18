package com.example.demo.Controllers;

import com.example.demo.DTOs.BookingDTO;
import com.example.demo.Services.BookingService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {
    BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/booking")
    BookingDTO createBooking(@RequestBody ObjectNode body) {
        return bookingService.createBooking(body.get("title").asText(),  body.get("name").asText(), body.get("dateTime").asText(),
                body.get("email").asText(), body.get("row").asInt(), body.get("seat_num").asInt());
    }
}