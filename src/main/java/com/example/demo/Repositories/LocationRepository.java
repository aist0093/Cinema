package com.example.demo.Repositories;

import com.example.demo.Entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Integer> {
    Location findLocationByLocation(Integer id);
    List<Location> findAll();
}
