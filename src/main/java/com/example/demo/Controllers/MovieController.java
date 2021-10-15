package com.example.demo.Controllers;

import com.example.demo.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class MovieController {

    @Autowired
    MovieService movieService;

    //WORKS
    @GetMapping(value = "/movie/{id}")
    public String getMovieInfo(@PathVariable String id) throws IOException {
        return movieService.fetchMovie(id).toString();
    }
}
