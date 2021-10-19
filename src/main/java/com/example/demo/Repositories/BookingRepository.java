package com.example.demo.Repositories;

import com.example.demo.Entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
    Booking findBookingByEmailAndBooking(String email, Integer bookingId);
    Booking findBookingByBooking(Integer bookingId);

}
