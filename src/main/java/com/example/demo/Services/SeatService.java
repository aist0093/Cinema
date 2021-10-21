package com.example.demo.Services;

import com.example.demo.Entities.Auditorium;
import com.example.demo.Entities.Booking;
import com.example.demo.Entities.Seat;
import com.example.demo.Entities.Viewing;
import com.example.demo.Repositories.AuditoriumRepository;
import com.example.demo.Repositories.BookingRepository;
import com.example.demo.Repositories.SeatRepository;
import com.example.demo.Repositories.ViewingRepository;
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

    public String getSeatsByAuditoriumAndDateTime(Integer auditoriumId, String date, String time){
        try {
            String dateTimeStr = date + " " + time;
            Date dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(dateTimeStr);
//            Viewing viewing = viewingRepository.findViewingByAuditorium(auditoriumId);
//            System.out.println(viewing);
//            List<Booking> bookings = bookingRepository.findBookingsByViewing(viewing);
//            System.out.println(bookings.toString());
//            List<Seat> seats = new ArrayList<>();
//            for(Booking b : bookings)
//                seats.addAll(seatRepository.findSeatsByBooking(b));
            Auditorium auditorium = auditoriumRepository.findAuditoriumByAuditorium(auditoriumId);

            List<Viewing> viewings = viewingRepository.findViewingsByAuditorium(auditorium);

            List<Booking> bookings = new ArrayList<>();
            for(Viewing v : viewings)
                bookings.addAll(bookingRepository.findBookingsByViewing(v));

            List<Seat> seats = new ArrayList<>();
            for(Booking b : bookings)
                seats.addAll(seatRepository.findSeatsByBooking(b));

            return seats.toString();
        }
        catch(Exception ex){
            return "Error occured!";
        }
    }
}
