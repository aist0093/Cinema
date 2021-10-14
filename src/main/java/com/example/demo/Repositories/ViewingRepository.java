package com.example.demo.Repositories;

import com.example.demo.DTOs.ViewingDTO;
import com.example.demo.Entities.Viewing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ViewingRepository extends JpaRepository<ViewingDTO, Integer> {
    List<ViewingDTO> findViewingsByAuditoriumIdAndDateTime(Integer auditoriumId, Date dateTime);
    List<ViewingDTO> findViewingsByAuditoriumIdAndDateTimeAndDateTime(Integer auditoriumId, Date startDateTime, Date endDateTime);
    ViewingDTO findViewingByMovieId(Integer movieId);
    ViewingDTO findViewingByViewingId(@Param("viewing_id") Integer viewingId);
    ViewingDTO setDateTimeByViewingId(Date dateTime, Integer viewingId);

}
