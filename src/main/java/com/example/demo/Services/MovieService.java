package com.example.demo.Services;


import com.example.demo.DTOs.MovieDTO;
import com.example.demo.DTOs.ViewingDTO;
import com.example.demo.Entities.Auditorium;
import com.example.demo.Entities.ImdbMovie;
import com.example.demo.Entities.Movie;

import com.example.demo.Entities.Viewing;
import com.example.demo.Repositories.MovieRepository;

import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Map<String, String> findMovie(Integer id) throws IOException {
        Movie movie = movieRepository.findMovieByMovie(id);
        System.out.println(movie.getTitle());
        if(movie.getTitle() .equals("")) {
            ImdbMovie imdbMovie = fetchMovie(movie.getImdbId());
            System.out.println(movie.getTitle());
            movie.setTitle(imdbMovie.getTitle());
            movie.setActors(imdbMovie.getActors());
            movie.setImage(imdbMovie.getImage());
            movie.setDuration(imdbMovie.getDuration());
            movie.setRate(imdbMovie.getRating());
            movie.setAgeRequirement(movie.getAgeRequirement());
            movie.setDescription(imdbMovie.getDescription());
            movie.setVideo(imdbMovie.getVideo());
            movieRepository.save(movie);
        }
        HashMap<String, String> map = new HashMap<>();


        map.put("title", movie.getTitle());
        map.put("description", movie.getDescription());
        map.put("rating", movie.getRate());
        map.put("duration", movie.getDuration());
        map.put("actors", movie.getActors());
        map.put("image" , movie.getImage());
        map.put("video" , movie.getVideo());
        map.put("ageReq", String.valueOf(movie.getAgeRequirement()));

        return map;

    }

    public static String regEx(String source, String pattern, String name) {
        Matcher m = Pattern.compile(pattern).matcher(source);
        if (m.find()) {
            if (name != null)
                return m.group(name);
            else return m.group();
        }
        return null;
    }

    public static ArrayList<String> multiRegEx(String source, String pattern, String name) {
        Matcher m = Pattern.compile(pattern).matcher(source);
        ArrayList<String> res = new ArrayList<>();
        while (m.find()) {
            if (name != null)
                res.add(m.group(name));
            else res.add(m.group());
        }
        return res;
    }

    public static String contentBetween(String content, String start, String end) {
        return content.replaceAll(start + "|" + end, "");
    }

    public static ImdbMovie fetchMovie(String id) throws IOException {
        Scanner sc = new Scanner(new URL("https://www.imdb.com/title/" + id + "/").openStream());
        StringBuffer sb = new StringBuffer();
        while (sc.hasNext()) {
            sb.append(sc.next());
            sb.append(" ");
        }
        String html = sb.toString();

        String title = regEx(html, "<h1.*?>(?<title>.*?)</h1>", "title");
        String description = regEx(html, "description\":\"(?<text>.*?)\",\"review\"", "text");
        String rating = regEx(html, ".*?>(?<rating>\\d{1,2}\\.\\d)</span><span>/<!-- -->10.*", "rating");
        String duration = regEx(html, "\\dh \\d{1,2}min", null);
        String actors = regEx(multiRegEx(html, "StyledComponents__ActorName-[a-zA-Z0-9-]+ [a-zA-Z0-9-]+\">(?<actor>[a-zA-Z ]+)<", "actor").toString(), "\\[(?<actors>.*?)\\]", "actors");


        return new ImdbMovie(title, description, rating, duration, actors, "", "");
    }



}
