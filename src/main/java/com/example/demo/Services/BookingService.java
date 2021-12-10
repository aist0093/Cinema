package com.example.demo.Services;

import com.example.demo.DTOs.BookingDTO;
import com.example.demo.Entities.Booking;
import com.example.demo.Entities.Seat;
import com.example.demo.Entities.Viewing;
import com.example.demo.Repositories.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final MovieRepository movieRepository;
    private final AuditoriumRepository auditoriumRepository;
    private final ViewingRepository viewingRepository;
    private final SeatRepository seatRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository, MovieRepository movieRepository,
                          AuditoriumRepository auditoriumRepository, ViewingRepository viewingRepository,
                          SeatRepository seatRepository) {
        this.bookingRepository = bookingRepository;
        this.movieRepository = movieRepository;
        this.auditoriumRepository = auditoriumRepository;
        this.viewingRepository = viewingRepository;
        this.seatRepository = seatRepository;
    }

    public BookingDTO createBooking(Integer viewingId, String email, ArrayNode seats) {
        try {
            Viewing viewing = viewingRepository.findViewingByViewing(viewingId);
            Booking b = bookingRepository.save(new Booking(viewing, email));
            Iterator<JsonNode> seatIterator = seats.elements();
            while(seatIterator.hasNext()){
                JsonNode seat = seatIterator.next();
                seatRepository.save(new Seat(b, seat.get("row").asInt(), seat.get("seat").asInt()));
            }
            return new BookingDTO(b);
        } catch (Exception ex) {
            System.out.println("Failed");
        }
        return null;
    }

    public List<BookingDTO> getBookings(String email){
        List<Booking> bookings = bookingRepository.findBookingsByEmail(email);
        ArrayList<BookingDTO> bookingDTOs = new ArrayList<>();
        for(Booking b : bookings){
            bookingDTOs.add(new BookingDTO(b));
        }
        return bookingDTOs;
    }

    @Transactional
    public void deleteBooking(String email, Integer bookingId) {
        Booking b = bookingRepository.findBookingByEmailAndBooking(email, bookingId);
        if(b != null){
            seatRepository.deleteSeatsByBooking(b);
            bookingRepository.deleteById(bookingId);
        }
    }

    @Transactional
    public BookingDTO updateBookingInfo(Integer id, ObjectNode info){
        Booking b = bookingRepository.findBookingByEmailAndBooking(info.get("email").asText(), id);
        if(b == null) return null;

        b.setViewing(viewingRepository.findViewingByViewing(info.get("viewing").asInt()));

        seatRepository.deleteAllByBooking(b);
        Iterator<JsonNode> seatIterator = info.get("seats").elements();
        while(seatIterator.hasNext()){
            JsonNode seat = seatIterator.next();
            seatRepository.save(new Seat(b, seat.get("row").asInt(), seat.get("seat").asInt()));
        }

        return new BookingDTO(bookingRepository.save(b));
    }
}
