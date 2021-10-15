package com.example.demo.Services;

import com.example.demo.Entities.ImdbMovie;
import com.example.demo.Entities.Movie;
import com.example.demo.Repositories.AuditoriumRepository;
import com.example.demo.Repositories.LocationRepository;
import com.example.demo.Repositories.MovieRepository;
import com.example.demo.Repositories.ViewingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie findMovie(Integer id){
        return movieRepository.findMovieByMovie(id);
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

    public ImdbMovie fetchMovie(String id) throws IOException {
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
        String length = regEx(html, "\\dh \\d{1,2}min", null);
        String actors = regEx(multiRegEx(html, "StyledComponents__ActorName-[a-zA-Z0-9-]+ [a-zA-Z0-9-]+\">(?<actor>[a-zA-Z ]+)<", "actor").toString(), "\\[(?<actors>.*?)\\]", "actors");

        return new ImdbMovie(title, description, rating, length, actors);
    }
}
