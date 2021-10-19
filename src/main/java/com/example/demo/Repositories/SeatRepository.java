package com.example.demo.Repositories;

import com.example.demo.Entities.Booking;
import com.example.demo.Entities.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Integer> {
    Seat findSeatByBooking(Booking booking);
}
