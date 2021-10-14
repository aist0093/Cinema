package com.example.demo.Repositories;

import com.example.demo.Entities.Auditorium;
import com.example.demo.Entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditoriumRepository extends JpaRepository<Auditorium, Integer> {
    Auditorium findAuditoriumByAuditoriumId(Integer id);
}
