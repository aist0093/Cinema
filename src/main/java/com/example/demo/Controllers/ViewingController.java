package com.example.demo.Controllers;

import com.example.demo.DTOs.ViewingDTO;
import com.example.demo.Entities.Viewing;
import com.example.demo.Services.ViewingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/viewing")
public class ViewingController {
    ModelMapper modelMapper;
    ViewingService viewingService;

    @Autowired
    public ViewingController(ViewingService viewingService) {
//        this.modelMapper = modelMapper;
        this.viewingService = viewingService;
    }

    //helper method to convert entity -> DTO
    private ViewingDTO convertToDto(Viewing viewing) {
        return modelMapper.map(viewing, ViewingDTO.class);
    }

    //helper method to convert DTO -> entity
    private Viewing convertToEntity(ViewingDTO viewingDTO) {
        return modelMapper.map(viewingDTO, Viewing.class);
    }


    //delete viewing by id
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    ViewingDTO deleteViewing(@PathVariable int id) {
        viewingService.delete(id);
        return null;
    }
    //update viewing date and time
    @PatchMapping("/{id}")
    ViewingDTO updateDateAndTime(@PathVariable Date dateTime, int id) {
        return viewingService.setDateTimeByViewingId(dateTime, id);
    }
    //create a viewing
    @PostMapping("")
    ViewingDTO createViewing(@PathVariable Integer movie_id, Integer auditorium_id, Date date_time, float price) {
        return viewingService.create(auditorium_id, movie_id, date_time, price);
    }
    //WORKS
    //get viewing by id
    @GetMapping("/{id}")
    ViewingDTO getViewingById(@PathVariable int id) {
        return viewingService.getById(id);
    }

//    @GetMapping("/location/{id}?date={date} ")
//    List<ViewingDTO> getViewingsByIdAndDate(@PathVariable int id, Date date){
//        return
//    }

}
