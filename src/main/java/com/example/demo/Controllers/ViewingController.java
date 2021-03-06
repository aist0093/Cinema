package com.example.demo.Controllers;

import com.example.demo.DTOs.LocationDTO;
import com.example.demo.DTOs.ViewingDTO;
import com.example.demo.Services.ViewingService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@RestController
@CrossOrigin(origins="*")
public class ViewingController {
    ViewingService viewingService;

    @Autowired
    public ViewingController(ViewingService viewingService) {
        this.viewingService = viewingService;
    }

    //delete viewing by id
    @DeleteMapping("/viewing/{id}")
    void deleteViewing(@PathVariable int id, HttpServletResponse response) {
        if (!viewingService.deleteViewing(id))
            response.setStatus(HttpServletResponse.SC_CONFLICT);
    }


    //update viewing date and time
    @PatchMapping("/viewing/{id}")
    ViewingDTO updateDateAndTime(@RequestBody ObjectNode body, @PathVariable int id) {
        return viewingService.setDateTimeByViewing(body.get("dateTime").asText(), id);
    }

    //create a viewing
    @PostMapping("/viewing")
    ViewingDTO createViewing(@RequestBody ObjectNode body) {
        System.out.println(body.get("movieId").asInt());
        return viewingService.create(body.get("movieId").asInt(), body.get("auditoriumId").asInt(), body.get("dateTime").asText(), body.get("price").asDouble());
    }

    //get viewing by id
    @GetMapping("/viewing/{id}")
    ViewingDTO getViewingById(@PathVariable int id) {
        return viewingService.getById(id);
    }

    @GetMapping("/viewings/location/{id}")
    List<ViewingDTO> getViewingsByIdAndDate(@PathVariable Integer id,
                                            @RequestParam(required = false) String date,
                                            @RequestParam(required = false) String start_date,
                                            @RequestParam(required = false) String end_date)
            throws IOException {
        if (date != null)
            return viewingService.getByLocationAndTimeframe(id, date, date);
        else if (start_date != null && end_date != null)
            return viewingService.getByLocationAndTimeframe(id, start_date, end_date);
        else return null;
    }

    @GetMapping("/locations")
    List<LocationDTO> getLocations(){
        return viewingService.getLocations();
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
