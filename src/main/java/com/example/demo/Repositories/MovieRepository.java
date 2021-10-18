package com.example.demo.Repositories;

import com.example.demo.Entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    Movie findMovieByMovie(Integer id);

    //Movie findMoviesByMovie(Integer movie_id, Integer age_req, String imdb_id, String actors, String image, String duration, String rate, String title, String video);


}
