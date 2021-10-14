package com.example.demo.Controllers.viewing;

import com.example.demo.DTOs.ViewingDTO;
import com.example.demo.Entities.Viewing;
import com.example.demo.Services.ViewingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/viewings")
public class ViewingController{
    ModelMapper modelMapper;
    private ViewingService viewingService;

    @Autowired
    public ViewingController(ModelMapper modelMapper, ViewingService viewingService){
        this.modelMapper = modelMapper;
        this.viewingService = viewingService;
    }

    //helper method to convert entity -> DTO
    private ViewingDTO convertToDto(Viewing viewing) {
        return modelMapper.map(viewing, ViewingDTO.class);
    }

    //helper method to convert DTO -> entity
    private Viewing convertToEntity(ViewingDTO paymentDto) {
        return modelMapper.map(paymentDto, Viewing.class);
    }


    @DeleteMapping("/viewing/{id}")
     ViewingDTO deleteViewing(@PathVariable int id){
        viewingService.delete(id);
        return null;
    }

    @PatchMapping("/viewing/{id}")
    ViewingDTO updateDateAndTime(@PathVariable Date dateTime, int id){
      return viewingService.setDateTimeByViewingId(dateTime, id);
    }



}
