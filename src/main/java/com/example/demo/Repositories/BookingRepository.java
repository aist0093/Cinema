package com.example.demo.Repositories;

import com.example.demo.Entities.Booking;
import com.example.demo.Entities.Viewing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
    Booking findBookingByEmailAndBooking(String email, Integer bookingId);
    Booking findBookingByBooking(Integer bookingId);
    List<Booking> findBookingsByViewing(Viewing viewing);

}
