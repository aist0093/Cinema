package com.example.demo.Services;

import com.example.demo.DTOs.ViewingDTO;
import com.example.demo.Entities.Auditorium;
import com.example.demo.Entities.Movie;
import com.example.demo.Entities.Viewing;
import com.example.demo.Repositories.AuditoriumRepository;
import com.example.demo.Repositories.MovieRepository;
import com.example.demo.Repositories.ViewingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ViewingService {

    private final ViewingRepository viewingRepository;
    private final AuditoriumRepository auditoriumRepository;
    private final MovieRepository movieRepository;

    @Autowired
    public ViewingService(ViewingRepository viewingRepository, AuditoriumRepository auditoriumRepository, MovieRepository movieRepository) {
        this.viewingRepository = viewingRepository;
        this.auditoriumRepository = auditoriumRepository;
        this.movieRepository = movieRepository;
    }

    public ViewingDTO create(Integer movie_id, Integer auditorium_id, Date date_time, float price) {
        Movie m = movieRepository.findMovieByMovieId(movie_id);
        Auditorium a = auditoriumRepository.findAuditoriumByAuditoriumId(auditorium_id);
        return new ViewingDTO(viewingRepository.save(new Viewing(a, m, date_time, price)));
    }

    public void delete(int viewingId) {
        if (!viewingRepository.existsById(viewingId)) System.out.println("viewing doesn't exist");
        viewingRepository.deleteById(viewingId);
    }

    public ViewingDTO setDateTimeByViewingId(Date dateTime, int viewingId) {
        ViewingDTO v = new ViewingDTO(viewingRepository.findViewingByViewingId(viewingId));
        v.setDateTime(dateTime);
        return v;
    }

    public ViewingDTO getById(int viewingId) {
        return new ViewingDTO(viewingRepository.findViewingByViewingId(viewingId));

    }
}
