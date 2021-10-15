package com.example.demo.Repositories;

import com.example.demo.DTOs.ViewingDTO;
import com.example.demo.Entities.Location;
import com.example.demo.Entities.Viewing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ViewingRepository extends JpaRepository<Viewing, Integer> {
    Viewing findViewingByViewingId(Integer viewingId);
    List<Viewing> findViewingsByAuditorium_LocationAndDateTimeIsGreaterThanEqualAndDateTimeIsLessThanEqual(Location location, Date dateTimeOne, Date dateTimeTwo);
}
