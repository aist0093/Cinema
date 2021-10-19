package com.example.demo.Services;

import com.example.demo.DTOs.ViewingDTO;
import com.example.demo.Entities.*;
import com.example.demo.Repositories.AuditoriumRepository;
import com.example.demo.Repositories.LocationRepository;
import com.example.demo.Repositories.MovieRepository;
import com.example.demo.Repositories.ViewingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ViewingService {

    private final ViewingRepository viewingRepository;
    private final AuditoriumRepository auditoriumRepository;
    private final MovieRepository movieRepository;
    private final LocationRepository locationRepository;
    private final MovieService movieService;

    @Autowired
    public ViewingService(ViewingRepository viewingRepository, AuditoriumRepository auditoriumRepository, MovieRepository movieRepository, LocationRepository locationRepository,MovieService movieService) {
        this.viewingRepository = viewingRepository;
        this.auditoriumRepository = auditoriumRepository;
        this.movieRepository = movieRepository;
        this.locationRepository = locationRepository;
        this.movieService = movieService;
    }

    public ViewingDTO create(Integer movie_id, Integer auditorium_id, String date_time, double price) {
        try {
            Movie m = movieRepository.findMovieByMovie(movie_id);
            Auditorium a = auditoriumRepository.findAuditoriumByAuditorium(auditorium_id);
            Date dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(date_time);
            Viewing v = viewingRepository.save(new Viewing(a, m, dateTime, (float) price));
            ViewingDTO vDTO = new ViewingDTO(v);
            return vDTO;
        }
        catch (Exception ex){
            System.out.println("Failed");
        }

        return null;
    }

    public void deleteViewing(int viewingId) {
        //if (!viewingRepository.existsById(viewingId)) System.out.println("viewing doesn't exist");
        viewingRepository.deleteById(viewingId);
    }

    public ViewingDTO setDateTimeByViewing( String dateTime, int viewingId) {

        System.out.println(dateTime);
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateTime);
            Viewing v = viewingRepository.findViewingByViewing(viewingId);
            v.setDateTime(date);
            return new ViewingDTO(viewingRepository.save(v));
         }
        catch(Exception ex){
            System.out.println("Failed!");
        }
        return null;
    }

    public ViewingDTO getById(int viewingId) {
        return new ViewingDTO(viewingRepository.findViewingByViewing(viewingId));

    }

    public List<ViewingDTO> getByLocationAndTimeframe(Integer location_id, String dateTimeFrom, String dateTimeTo) throws IOException {
        try {
            Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateTimeFrom);
            Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateTimeTo);
            Calendar c = Calendar.getInstance();
            c.setTime(endDate);
            c.add(Calendar.DATE, 1);  // number of days to add
            endDate = c.getTime();  // dt is now the new date
            Location location = locationRepository.findLocationByLocation(location_id);
            System.out.println(startDate);
            System.out.println(endDate);
            List<Viewing> vList = viewingRepository.findViewingsByAuditorium_LocationAndDateTimeIsGreaterThanEqualAndDateTimeIsLessThan(location, startDate, endDate);
            List<ViewingDTO> vDTOList = new ArrayList<>();
            for(Viewing v : vList){
                ViewingDTO vDTO = new ViewingDTO(v);
                vDTOList.add(vDTO);
            }

            return vDTOList;
        }
        catch (ParseException ex){
            System.out.println("Failed to parse!");
        }

        return null;
    }


}
