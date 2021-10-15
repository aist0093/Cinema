package com.example.demo.Services;

import com.example.demo.DTOs.ViewingDTO;
import com.example.demo.Entities.Auditorium;
import com.example.demo.Entities.Location;
import com.example.demo.Entities.Movie;
import com.example.demo.Entities.Viewing;
import com.example.demo.Repositories.AuditoriumRepository;
import com.example.demo.Repositories.LocationRepository;
import com.example.demo.Repositories.MovieRepository;
import com.example.demo.Repositories.ViewingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ViewingService {

    private final ViewingRepository viewingRepository;
    private final AuditoriumRepository auditoriumRepository;
    private final MovieRepository movieRepository;
    private final LocationRepository locationRepository;

    @Autowired
    public ViewingService(ViewingRepository viewingRepository, AuditoriumRepository auditoriumRepository, MovieRepository movieRepository, LocationRepository locationRepository) {
        this.viewingRepository = viewingRepository;
        this.auditoriumRepository = auditoriumRepository;
        this.movieRepository = movieRepository;
        this.locationRepository = locationRepository;
    }

    public ViewingDTO create(Integer movie_id, Integer auditorium_id, String date_time, double price) {
        try {
            Movie m = movieRepository.findMovieByMovieId(movie_id);
            Auditorium a = auditoriumRepository.findAuditoriumByAuditoriumId(auditorium_id);
            Date dateTime = new SimpleDateFormat("yyyy-MM-dd").parse(date_time);
            return new ViewingDTO(viewingRepository.save(new Viewing(a, m, dateTime, new Float(price))));
        }
        catch (ParseException ex){
            System.out.println("Failed to parse!");
        }

        return null;
    }

    public void delete(int viewingId) {
        if (!viewingRepository.existsById(viewingId)) System.out.println("viewing doesn't exist");
        viewingRepository.deleteById(viewingId);
    }

    public ViewingDTO setDateTimeByViewingId( String dateTime, int viewingId) {

        System.out.println(dateTime);
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateTime);
            Viewing v = viewingRepository.findViewingByViewingId(viewingId);
            v.setDateTime(date);
            return new ViewingDTO(viewingRepository.save(v));
         }
        catch(ParseException ex){
            System.out.println("Failed to parse!");
        }
        return null;
    }

    public ViewingDTO getById(int viewingId) {
        return new ViewingDTO(viewingRepository.findViewingByViewingId(viewingId));

    }

    public List<ViewingDTO> getByLocationAndTimeframe(Integer location_id, String dateTimeFrom, String dateTimeTo) {
        try {
            Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateTimeFrom);
            Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateTimeTo);
            Location location = locationRepository.findLocationByLocationId(location_id);

            List<Viewing> vList = viewingRepository.findViewingsByAuditorium_LocationContainingAndDateTimeIsGreaterThanEqualAndDateTimeIsLessThanEqual(location, startDate, endDate);
            List<ViewingDTO> vDTOList = new ArrayList<>();
            for(Viewing v : vList){
                vDTOList.add(new ViewingDTO(v));
            }

            return vDTOList;
        }
        catch (ParseException ex){
            System.out.println("Failed to parse!");
        }

        return null;
    }


}
