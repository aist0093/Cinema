package com.example.demo.Repositories;

import com.example.demo.Entities.Auditorium;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditoriumRepository extends JpaRepository<Auditorium, Integer> {
}
