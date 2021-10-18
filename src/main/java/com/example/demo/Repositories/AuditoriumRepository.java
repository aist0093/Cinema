package com.example.demo.Repositories;

import com.example.demo.Entities.Auditorium;
import com.example.demo.Entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditoriumRepository extends JpaRepository<Auditorium, Integer> {
    Auditorium findAuditoriumByAuditorium(Integer id);
    Location findLocationByAuditorium(Integer id);
    Auditorium findAuditoriumByName(String name);
}
