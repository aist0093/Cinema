package com.example.demo.Controllers;

import com.example.demo.DTOs.BookingDTO;
import com.example.demo.Services.BookingService;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@RestController
@CrossOrigin(origins="*")
public class BookingController {
    BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    // delete a booking
    @DeleteMapping("/booking/{bookingId}")
    public void deleteOneBooking(@RequestParam String email, @PathVariable int bookingId) {
        bookingService.deleteBooking(email, bookingId);
    }

    //create a booking
    @PostMapping("/booking")
    public BookingDTO createBooking(@RequestBody ObjectNode body) {
        return bookingService.createBooking(body.get("viewing").asInt(),
                body.get("email").asText(), (ArrayNode) body.get("seats"));
    }

    //update a booking
    @PutMapping("/booking/{id}")
    public BookingDTO updateRowAndSeat(@RequestBody ObjectNode body, @PathVariable int id) {
        return bookingService.updateBookingInfo(id, body);
    }
//
//    @Bean
//    public WebMvcConfigurer configure(){
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry){
//                registry.addMapping("/*").allowedOrigins("https://cinema-backend1.herokuapp.com/");
//            }
//        };
//    }
}