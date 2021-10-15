package com.example.demo.Controllers;

import com.example.demo.DTOs.ViewingDTO;
import com.example.demo.Entities.Viewing;
import com.example.demo.Services.ViewingService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ViewingController {
    ModelMapper modelMapper;
    ViewingService viewingService;

    @Autowired
    public ViewingController(ViewingService viewingService) {
//        this.modelMapper = modelMapper;
        this.viewingService = viewingService;
    }

    //delete viewing by id
    @DeleteMapping("/viewing/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    ViewingDTO deleteViewing(@PathVariable int id) {
        viewingService.delete(id);
        return null;
    }
    //update viewing date and time
    @PatchMapping("/viewing/{id}")
    ViewingDTO updateDateAndTime(@RequestBody ObjectNode body, @PathVariable int id) {
        return viewingService.setDateTimeByViewingId(body.get("dateTime").asText(), id);
    }
    //create a viewing
    @PostMapping("/viewing")
    ViewingDTO createViewing(@RequestBody ObjectNode body) {
        return viewingService.create(body.get("auditoriumId").asInt(), body.get("movieId").asInt(), body.get("dateTime").asText(), body.get("price").asDouble());
    }
    //WORKS
    //get viewing by id
    @GetMapping("/viewing/{id}")
    ViewingDTO getViewingById(@PathVariable int id) {
        return viewingService.getById(id);
    }

    @GetMapping("/viewings/location/{id}?date={date}")
    List<ViewingDTO> getViewingsByIdAndDate(@PathVariable int id, @PathVariable String date){
        return viewingService.getByLocationAndTimeframe(id, date, date);
    }

    @GetMapping("/viewings/location/{id}")
    List<ViewingDTO> getViewingsByIdAndDate(@PathVariable int id, @RequestParam String start_date, @RequestParam String end_date) {
        return viewingService.getByLocationAndTimeframe(id, start_date, end_date);
    }

}
