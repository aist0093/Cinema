package com.example.demo.Controllers.viewing;

import com.example.demo.DTOs.ViewingDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface IViewingController {

    @GetMapping("GET /movie/{id} ")
    ViewingDTO getById(@PathVariable int id);
}
