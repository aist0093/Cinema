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

    private final static String OmdbApiKey = "544f4d8a";
    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

//    public static String regEx(String source, String pattern, String name) {
//        Matcher m = Pattern.compile(pattern).matcher(source);
//        if (m.find()) {
//            if (name != null)
//                return m.group(name);
//            else return m.group();
//        }
//        return null;
//    }
//
//    public static ArrayList<String> multiRegEx(String source, String pattern, String name) {
//        Matcher m = Pattern.compile(pattern).matcher(source);
//        ArrayList<String> res = new ArrayList<>();
//        while (m.find()) {
//            if (name != null)
//                res.add(m.group(name));
//            else res.add(m.group());
//        }
//        return res;
//    }

//    public static ImdbMovie fetchMovie(String id) throws IOException {
//        Scanner sc = new Scanner(new URL("https://www.imdb.com/title/" + id + "/").openStream());
//        StringBuffer sb = new StringBuffer();
//        while (sc.hasNext()) {
//            sb.append(sc.next());
//            sb.append(" ");
//        }
//        String html = sb.toString();
//
//        String title = regEx(html, "<h1.*?>(?<title>.*?)</h1>", "title");
//        String description = regEx(html, "description\":\"(?<text>.*?)\",\"review\"", "text");
//        String rating = regEx(html, ".*?>(?<rating>\\d{1,2}\\.\\d)</span><span>/<!-- -->10.*", "rating");
//        String duration = regEx(html, "\\dh \\d{1,2}min", null);
//        String actors = regEx(multiRegEx(html, "StyledComponents__ActorName-[a-zA-Z0-9-]+ [a-zA-Z0-9-]+\">(?<actor>[a-zA-Z ]+)<", "actor").toString(), "\\[(?<actors>.*?)\\]", "actors");
//        String poster = regEx(html, "<a class=\"ipc-lockup-overlay ipc-focusable\" href=\"(?<link>.*?)\" aria-label", "link");
//        System.out.println(poster);
//
//        return new ImdbMovie(title, description, rating, duration, actors, "", "");
//    }

    public Map<String, String> findMovie(Integer id) throws Exception {
        Movie movie = movieRepository.findMovieByMovie(id);
        System.out.println(movie.getTitle());
        if (movie.getTitle() == null) {
            updateMovieInfo(movie);
            //if (movie.getTitle().equals(""));
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
        String urlString = "http://www.omdbapi.com/?i=" + m.getImdbId() + "&apikey=" + OmdbApiKey;
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
