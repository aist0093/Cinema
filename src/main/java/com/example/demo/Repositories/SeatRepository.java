package com.example.demo.Repositories;

import com.example.demo.Entities.Seat;
import org.springframework.data.repository.CrudRepository;

public interface SeatRepository extends CrudRepository<Seat, Integer> {
}
