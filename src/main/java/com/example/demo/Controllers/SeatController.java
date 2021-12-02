package com.example.demo.Controllers;

import com.example.demo.Services.BookingService;
import com.example.demo.Services.SeatService;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@RestController
@CrossOrigin(origins="*")
public class SeatController {

    SeatService seatService;

    @Autowired
    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @GetMapping("/seats/auditorium/{id}")
    public ArrayNode getSeats(@PathVariable Integer id, @RequestParam String date, @RequestParam String time){
        return seatService.getSeatsByAuditoriumAndDateTime(id, date, time);
    }

    @Bean
    public WebMvcConfigurer configure(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry){
                registry.addMapping("/*").allowedOrigins("https://cinema-backend1.herokuapp.com/");
            }
        };
    }
}
