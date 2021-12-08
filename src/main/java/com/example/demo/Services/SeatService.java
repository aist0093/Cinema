package com.example.demo.Services;

import com.example.demo.Entities.Auditorium;
import com.example.demo.Entities.Booking;
import com.example.demo.Entities.Seat;
import com.example.demo.Entities.Viewing;
import com.example.demo.Repositories.AuditoriumRepository;
import com.example.demo.Repositories.BookingRepository;
import com.example.demo.Repositories.SeatRepository;
import com.example.demo.Repositories.ViewingRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SeatService {
    private final ViewingRepository viewingRepository;
    private final SeatRepository seatRepository;
    private final BookingRepository bookingRepository;
    private final AuditoriumRepository auditoriumRepository;

    @Autowired
    public SeatService(ViewingRepository viewingRepository, SeatRepository seatRepository, BookingRepository bookingRepository, AuditoriumRepository auditoriumRepository) {
        this.viewingRepository = viewingRepository;
        this.seatRepository = seatRepository;
        this.bookingRepository = bookingRepository;
        this.auditoriumRepository = auditoriumRepository;
    }

    public ArrayNode getSeatsByAuditoriumAndDateTime(Integer auditoriumId, String date, String time){
        try {
            String dateTimeStr = date + " " + time;
            Date dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(dateTimeStr);
            Auditorium auditorium = auditoriumRepository.findAuditoriumByAuditorium(auditoriumId);

            List<Viewing> viewings = viewingRepository.findViewingsByAuditoriumAndDateTime(auditorium, dateTime);

            List<Booking> bookings = new ArrayList<>();
            for(Viewing v : viewings)
                bookings.addAll(bookingRepository.findBookingsByViewing(v));

            List<Seat> seats = new ArrayList<>();
            for(Booking b : bookings)
                seats.addAll(seatRepository.findSeatsByBooking(b));

            ObjectMapper m = new ObjectMapper();
            ArrayNode jsonSeats = m.createArrayNode();
            for(Seat s : seats){
                ObjectNode o = m.createObjectNode();
                o.put("row", s.getRow());
                o.put("seat", s.getSeat());
                jsonSeats.add(o);
            }

            return jsonSeats;
        }
        catch(Exception ex){
            return null;
        }
    }

    public ArrayNode getSeatsByViewing(Integer viewingId){
        try {
            Viewing viewing = viewingRepository.findViewingByViewing(viewingId);

            List<Booking> bookings = bookingRepository.findBookingsByViewing(viewing);

            List<Seat> seats = new ArrayList<>();
            for(Booking b : bookings)
                seats.addAll(seatRepository.findSeatsByBooking(b));

            ObjectMapper m = new ObjectMapper();
            ArrayNode jsonSeats = m.createArrayNode();
            for(Seat s : seats){
                ObjectNode o = m.createObjectNode();
                o.put("row", s.getRow());
                o.put("seat", s.getSeat());
                jsonSeats.add(o);
            }

            return jsonSeats;
        }
        catch(Exception ex){
            return null;
        }
    }
}
