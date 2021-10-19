package com.example.demo.Controllers;

import com.example.demo.Entities.ImdbMovie;
import com.example.demo.Entities.Movie;
import com.example.demo.Services.MovieService;
import com.example.demo.Services.ViewingService;
import org.json.JSONException;
import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class MovieController {

    MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    //WORKS
    @GetMapping("/movie/{id}")
    public Map<String, String> getMovieInfo(@PathVariable Integer id) throws Exception {
               return movieService.findMovie(id);
    }


}
