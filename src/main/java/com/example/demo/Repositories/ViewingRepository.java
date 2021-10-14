package com.example.demo.Repositories;

import com.example.demo.DTOs.ViewingDTO;
import com.example.demo.Entities.Viewing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ViewingRepository extends JpaRepository<Viewing, Integer> {
//    List<Viewing> findViewingsByAuditoriumIdAndDateTime(Integer auditoriumId, Date dateTime);
//    List<Viewing> findViewingsByAuditoriumIdAndDateTimeAndDateTime(Integer auditoriumId, Date startDateTime, Date endDateTime);
//    Viewing findViewingByMovieId(Integer movieId);
    Viewing findViewingByViewingId(Integer viewingId);
//    Viewing setDateTimeByViewingId(Date dateTime, Integer viewingId);


}
