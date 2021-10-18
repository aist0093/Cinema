package com.example.demo.Repositories;

import com.example.demo.Entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    Movie findMovieByMovie(Integer id);
    Movie findMovieByTitle(String title);
}
