package com.example.demo.Controllers;

import com.example.demo.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/test")
    public String getTest(){
        return "It works!";
    }

    @GetMapping("/testone")
    public String getTestOne(){
        return "It works, test one";
    }
}

