package com.example.demo.Services;

import com.example.demo.Entities.Movie;
import com.example.demo.Repositories.MovieRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Map<String, String> findMovie(Integer id) throws Exception {
        Movie movie = movieRepository.findMovieByMovie(id);
        System.out.println(movie.getTitle());
        if (movie.getTitle() == null) {
            updateMovieInfo(movie);
        }
        HashMap<String, String> map = new HashMap<>();

        map.put("title", movie.getTitle());
        map.put("description", movie.getDescription());
        map.put("rating", movie.getRate());
        map.put("duration", movie.getDuration());
        map.put("actors", movie.getActors());
        map.put("image", movie.getImage());
        map.put("ageReq", String.valueOf(movie.getAgeRequirement()));

        return map;
    }

    public boolean updateMovieInfo(Movie m) throws Exception {
        if (m.getImdbId() == null)
            return false;
        String urlString = "http://www.omdbapi.com/?i=" + m.getImdbId() + "&apikey=${OMDB_APIKEY}";
        URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        con.disconnect();
        System.out.println(content.toString());

        JsonNode json = new ObjectMapper().readTree(content.toString());

        m.setTitle(json.get("Title").asText());
        m.setDescription(json.get("Plot").asText());
        m.setRate(json.get("imdbRating").asText());
        m.setDuration(json.get("Runtime").asText());
        m.setActors(json.get("Actors").asText());
        m.setImage(json.get("Poster").asText());
        movieRepository.save(m);

        return true;
    }
}
