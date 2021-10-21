package com.example.demo.Controllers;

import com.example.demo.Services.BookingService;
import com.example.demo.Services.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SeatController {

    SeatService seatService;

    @Autowired
    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @GetMapping("/seats/auditorium/{id}")
    public String getSeats(@PathVariable Integer id, @RequestParam String date, @RequestParam String time){
        return seatService.getSeatsByAuditoriumAndDateTime(id, date, time);
    }
}
