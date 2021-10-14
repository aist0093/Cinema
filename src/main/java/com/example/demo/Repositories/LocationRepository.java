package com.example.demo.Repositories;

import com.example.demo.Entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Integer> {
    Location findLocationByLocationId(Integer id);
}
