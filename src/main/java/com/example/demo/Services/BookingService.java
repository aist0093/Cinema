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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;


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


    public void deleteBooking(String email, Integer bookingId) {
        if(bookingRepository.findBookingByEmailAndBooking(email, bookingId) != null){
            seatRepository.deleteById((seatRepository.findSeatByBooking(bookingRepository
                    .findBookingByBooking(bookingId))).getSeatId());
            bookingRepository.deleteById(bookingId);
        }
    }

    public BookingDTO editBookingSeats(Integer bookingId, String email, Integer row, Integer seat_num) {
        Booking b = bookingRepository.findBookingByEmailAndBooking(email, bookingId);
        Seat s = seatRepository.findSeatByBooking(bookingRepository.findBookingByBooking(bookingId));
        s.setRow(row);
        s.setSeatNumber(seat_num);
        seatRepository.save(s);

        return new BookingDTO(bookingRepository.save(b));
    }

    public BookingDTO updateBookingInfo(Integer id, ObjectNode info){
        Booking b = bookingRepository.findBookingByEmailAndBooking(info.get("email").asText(), id);
        if(b == null) return null;

        b.setViewing(viewingRepository.findViewingByViewing(info.get("viewingId").asInt()));
        Iterator<JsonNode> seatIterator = info.get("seats").elements();
        while(seatIterator.hasNext()){
            JsonNode seat = seatIterator.next();
            seatRepository.save(new Seat(b, seat.get("row").asInt(), seat.get("seat").asInt()));
        }

        return new BookingDTO(bookingRepository.save(b));
    }
}
