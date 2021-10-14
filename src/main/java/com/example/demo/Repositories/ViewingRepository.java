package com.example.demo.Repositories;

import com.example.demo.Entities.Viewing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ViewingRepository extends JpaRepository<Viewing, Integer> {
    List<Viewing> findViewingsByAuditoriumIdAndDateTime(Integer auditoriumId, Date dateTime);
    List<Viewing> findViewingsByAuditoriumIdAndDateTimeAndDateTime(Integer auditoriumId, Date startDateTime, Date endDateTime);
    Viewing findViewingByMovieId(Integer movieId);
    Viewing findViewingByViewingId(Integer viewingId);
    Viewing setDateTimeByViewingId(Date dateTime);

}
