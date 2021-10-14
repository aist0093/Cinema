package com.example.demo.Services;

import com.example.demo.DTOs.ViewingDTO;
import com.example.demo.Entities.Viewing;
import com.example.demo.Repositories.ViewingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ViewingService{

    private final ViewingRepository viewingRepository;

    @Autowired
    public ViewingService(ViewingRepository viewingRepository){
        this.viewingRepository = viewingRepository;
    }

    public ViewingDTO create(Integer movie_id, Integer auditorium_id, Date date_time, float price) {
        return viewingRepository.save(new ViewingDTO(movie_id, auditorium_id, date_time, price) {
        });
    }


    public void delete(int viewingId) {
        if (!viewingRepository.existsById(viewingId)) System.out.println("viewing doesn't exist");
        viewingRepository.deleteById(viewingId);
    }

    public ViewingDTO setDateTimeByViewingId(Date dateTime, int viewingId){
        ViewingDTO v = viewingRepository.findViewingByViewingId(viewingId);
        v.setDateTime(dateTime);

        viewingRepository.setDateTimeByViewingId(dateTime, )
        return v;
    }

    public Viewing getById(int viewingId) {
        return null;
    }
}
