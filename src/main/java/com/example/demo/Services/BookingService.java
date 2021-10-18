package com.example.demo.Services;

import com.example.demo.DTOs.BookingDTO;
import com.example.demo.Entities.Auditorium;
import com.example.demo.Entities.Booking;
import com.example.demo.Entities.Movie;
import com.example.demo.Entities.Viewing;
import com.example.demo.Repositories.AuditoriumRepository;
import com.example.demo.Repositories.BookingRepository;
import com.example.demo.Repositories.MovieRepository;
import com.example.demo.Repositories.ViewingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final MovieRepository movieRepository;
    private final AuditoriumRepository auditoriumRepository;
    private final ViewingRepository viewingRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository, MovieRepository movieRepository, AuditoriumRepository auditoriumRepository, ViewingRepository viewingRepository) {
        this.bookingRepository = bookingRepository;
        this.movieRepository = movieRepository;
        this.auditoriumRepository = auditoriumRepository;
        this.viewingRepository = viewingRepository;
    }

    public BookingDTO createBooking(String title, String name, String date_time, String email) {
        try {
            Date dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(date_time);
            Viewing viewing = viewingRepository.findViewingByMovieAndAuditoriumAndDateTime(title, name, dateTime);
            Booking b = bookingRepository.save(new Booking(viewing, email));
            return new BookingDTO(b);
        } catch (Exception ex) {
            System.out.println("Failed");
        }
        return null;
    }
}
