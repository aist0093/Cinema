package com.example.demo.Services;

import com.example.demo.DTOs.BookingDTO;
import com.example.demo.Entities.*;
import com.example.demo.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;


@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final MovieRepository movieRepository;
    private final AuditoriumRepository auditoriumRepository;
    private final ViewingRepository viewingRepository;
    private final SeatRepository seatRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository, MovieRepository movieRepository, AuditoriumRepository auditoriumRepository, ViewingRepository viewingRepository, SeatRepository seatRepository) {
        this.bookingRepository = bookingRepository;
        this.movieRepository = movieRepository;
        this.auditoriumRepository = auditoriumRepository;
        this.viewingRepository = viewingRepository;
        this.seatRepository = seatRepository;
    }


public BookingDTO createBooking(String title, String name, String date_time, String email, Integer row, Integer seat_num) {
    try {
        Date dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(date_time);
        Viewing viewing = viewingRepository.findViewingByMovieTitleAndAuditoriumNameAndDateTime(title, name, dateTime);
        Booking b = bookingRepository.save(new Booking(viewing, email));
        Seat s = seatRepository.save(new Seat(b, row, seat_num));
        return new BookingDTO(b);
    } catch (Exception ex) {
        System.out.println("Failed");
    }
    return null;
}
}
