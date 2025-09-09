package org.lesson.java.best_of_the_year.controllers;

import java.util.ArrayList;
import java.util.List;

import org.lesson.java.best_of_the_year.classes.Movie;
import org.lesson.java.best_of_the_year.classes.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.websocket.server.PathParam;

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

        // String movies = "";

        // for (Movie movie : getBestMovie()) {
        // movies += movie.getTitle() + ", ";
        // }

        // String names = movies.substring(0, movies.length() - 2);

        // // model.addAttribute("title", "Movie");
        // model.addAttribute("names", names);

        // return "asString";
        model.addAttribute("pageTitle", "Best Movie");

        List<Movie> list = new ArrayList<Movie>();

        for (Movie movie : getBestMovie()) {
            list.add(movie);
        }

        model.addAttribute("list", list);

        return "asString";

    }

    @GetMapping("/songs")
    public String getSongsString(Model model) {

        // String songs = "";

        // for (Song song : getBestSongs()) {
        // songs += song.getTitle() + ", ";
        // }

        // String names = songs.substring(0, songs.length() - 2);

        // // model.addAttribute("title", "song");
        // model.addAttribute("names", names);

        // return "asString";

        model.addAttribute("pageTitle", "Best Song");

        List<Song> list = new ArrayList<Song>();

        for (Song song : getBestSongs()) {
            list.add(song);
        }

        model.addAttribute("list", list);

        return "asString";

    }

    @GetMapping("/movies/{id}")
    public String getSpecMovie(@PathVariable("id") Integer movieId, Model model) {

        // List<Movie> list = getBestMovie();

        String detailed = "";
        for (Movie movie : getBestMovie()) {
            if (movie.getId() == movieId) {
                detailed = movie.getTitle();
            }
        }

        model.addAttribute("detailed", detailed);

        return "detail";
    }

    @GetMapping("/songs/{id}")
    public String getSpecSong(@PathVariable("id") Integer songId, Model model) {

        String detailed = "";
        for (Song song : getBestSongs()) {
            if (song.getId() == songId) {
                detailed = song.getTitle();
            }
        }

        model.addAttribute("detailed", detailed);

        return "detail";
    }

}
