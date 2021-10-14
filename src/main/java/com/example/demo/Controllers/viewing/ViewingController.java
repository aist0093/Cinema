package com.example.demo.Controllers.viewing;

import com.example.demo.DTOs.ViewingDTO;
import com.example.demo.Entities.Viewing;
import com.example.demo.Services.IViewingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/viewings")
public class ViewingController implements IViewingController{
    IViewingService viewingService;
    ModelMapper modelMapper;

    @Autowired
    public ViewingController(IViewingService viewingService, ModelMapper modelMapper){
        this.viewingService = viewingService;
        this.modelMapper = modelMapper;
    }


    //helper method to convert entity -> DTO
    private ViewingDTO convertToDto(Viewing viewing) {
        return modelMapper.map(viewing, ViewingDTO.class);
    }

    //helper method to convert DTO -> entity
    private Viewing convertToEntity(ViewingDTO paymentDto) {
        return modelMapper.map(paymentDto, Viewing.class);
    }

    @Override
    public ViewingDTO getById(int id) {
        return convertToDto(viewingService.getById(id));
    }
}
