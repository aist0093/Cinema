package com.example.demo.Repositories;

import com.example.demo.Entities.Auditorium;
import com.example.demo.Entities.Booking;
import com.example.demo.Entities.Seat;
import com.example.demo.Entities.Viewing;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Integer> {
    Seat findSeatByBooking(Booking booking);
    List<Seat> findSeatsByBooking(Booking booking);
    void deleteSeatsByBooking(Booking booking);
    void deleteAllByBooking(Booking booking);
}
