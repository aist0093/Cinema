package com.example.demo.Repositories;

import com.example.demo.Entities.Auditorium;
import com.example.demo.Entities.Location;
import com.example.demo.Entities.Movie;
import com.example.demo.Entities.Viewing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ViewingRepository extends JpaRepository<Viewing, Integer> {
    Viewing findViewingByViewing(Integer viewingId);
    List<Viewing> findViewingsByAuditorium_LocationAndDateTimeIsGreaterThanEqualAndDateTimeIsLessThan(Location location, Date dateTimeOne, Date dateTimeTwo);
    Viewing findViewingByMovieTitleAndAuditoriumNameAndDateTime(String title, String name, Date startDate);
    List<Viewing> findViewingsByAuditoriumAndDateTime(Auditorium auditorium, Date dateTime);
    Viewing findViewingByDateTime(Date dateTime);
    List<Viewing> findViewingsByAuditorium(Auditorium auditorium);
}
