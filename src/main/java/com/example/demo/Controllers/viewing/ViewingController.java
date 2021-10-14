package com.example.demo.Controllers.viewing;

import com.example.demo.DTOs.ViewingDTO;
import com.example.demo.Entities.Viewing;
import com.example.demo.Services.ViewingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/viewing")
public class ViewingController{
    ModelMapper modelMapper;
    ViewingService viewingService;

    //helper method to convert entity -> DTO
    private ViewingDTO convertToDto(Viewing viewing) {
        return modelMapper.map(viewing, ViewingDTO.class);
    }

    //helper method to convert DTO -> entity
    private Viewing convertToEntity(ViewingDTO viewingDTO) {
        return modelMapper.map(viewingDTO, Viewing.class);
    }

    @Autowired
    public ViewingController(ModelMapper modelMapper, ViewingService viewingService){
        this.modelMapper = modelMapper;
        this.viewingService = viewingService;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    ViewingDTO deleteViewing(@PathVariable int id){
        viewingService.delete(id);
        return null;
    }

    @PatchMapping("/{id}")
    ViewingDTO updateDateAndTime(@PathVariable Date dateTime, int id){
      return viewingService.setDateTimeByViewingId(dateTime, id);
    }

    @PostMapping("")
    ViewingDTO createViewing(@PathVariable Integer movie_id, ){
        return viewingService.create(viewingDTO);
    }


}
