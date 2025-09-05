package org.lesson.java.best_of_the_year.controllers;

import java.util.ArrayList;
import java.util.List;

import org.lesson.java.best_of_the_year.classes.Movie;
import org.lesson.java.best_of_the_year.classes.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class HomeController {

    // -------------------- METODI -------------------------

    private List<Movie> getBestMovie() {
        List<Movie> list = new ArrayList<Movie>();

        list.add(new Movie(1, "Il cavaliere oscuro"));
        list.add(new Movie(2, "Il Signore degli anelli: La compagnia dell'anello"));
        list.add(new Movie(3, "Il Signore degli anelli: Il ritorno del re"));
        list.add(new Movie(4, "Spider-man 2"));
        list.add(new Movie(5, "Jhon Wick"));

        return list;
    }

    private List<Song> getBestSongs() {
        List<Song> list = new ArrayList<Song>();

        list.add(new Song(1, "Congratulations"));
        list.add(new Song(2, "Rap God"));
        list.add(new Song(3, "44 more"));
        list.add(new Song(4, "A2Z"));
        list.add(new Song(5, "The Lazy Song"));

        return list;

    }

    // ----------------------- MAPPATURE -------------------------

    @GetMapping("/")
    public String getBestYear(@RequestParam(name = "name") String name, Model model) {

        model.addAttribute("name", name);
        return "getBestOfTheYear";
    }

    @GetMapping("/movies")
    public String getMoviesString(Model model) {

        String movies = "";

        for (Movie movie : getBestMovie()) {
            movies += movie.getTitle() + ", ";
        }

        String names = movies.substring(0, movies.length() - 2);

        // model.addAttribute("title", "Movie");
        model.addAttribute("names", names);

        return "asString";

    }

    @GetMapping("/songs")
    public String getSongsString(Model model) {

        String songs = "";

        for (Song song : getBestSongs()) {
            songs += song.getTitle() + ", ";
        }

        String names = songs.substring(0, songs.length() - 2);

        // model.addAttribute("title", "song");
        model.addAttribute("names", names);

        return "asString";

    }

}
