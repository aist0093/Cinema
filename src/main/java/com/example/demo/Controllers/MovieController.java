package com.example.demo.Controllers;

import com.example.demo.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Map;

@RestController
@CrossOrigin(origins="*")
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

    @Bean
    public WebMvcConfigurer configure(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry){
                registry.addMapping("/*").allowedOrigins("*");
            }
        };
    }
}

