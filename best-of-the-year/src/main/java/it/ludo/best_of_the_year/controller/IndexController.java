package it.ludo.best_of_the_year.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import it.ludo.best_of_the_year.model.Movie;
import it.ludo.best_of_the_year.model.Song;
import it.ludo.best_of_the_year.model.User;

@Controller
public class IndexController {

    @GetMapping("/")
    public String year(Model model) {
        User user = new User("Ludovica");
        /*
         * (@RequestParam(name = "name", required = false) String name,
         * Model model)
         */

        model.addAttribute("user", user);
        return "year";
    }

    /*
     * Creare all’interno del controller due metodi privati :
     * - uno restituisce una lista di oggetti di tipo Movie - getBestMovies()
     * - l’altro restituisce una lista di oggetti di tipo Song - getBestSongs()
     */
    private List<Movie> getBestMovies() {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie(1, "Movie1"));
        movies.add(new Movie(2, "Movie2"));
        movies.add(new Movie(3, "Movie3"));
        return movies;
    }

    private List<Song> getBestSongs() {
        List<Song> songs = new ArrayList<>();
        songs.add(new Song(1, "Song1"));
        songs.add(new Song(2, "Song2"));
        songs.add(new Song(3, "Song3"));
        return songs;
    }

    /*
     * Aggiungere al controller altri due metodi, che rispondono agli url
     * - “/movies”
     * - “/songs”
     */

    @RequestMapping("/movies")
    public String movies(Model model) {
        List<Movie> movies = getBestMovies();
        model.addAttribute("movies", movies);
        return "movies";
    }

    @RequestMapping("/songs")
    public String songs(Model model) {
        List<Song> songs = getBestSongs();
        model.addAttribute("songs", songs);
        return "songs";
    }

    /*
     * Creare due metodi
     * - “/movies/{id}”
     * - “/songs/{id}”
     * che dato il parametro id passato tramite il path, mostri in pagina il titolo
     * relativo al film / canzone.
     */

    @RequestMapping("/movies/{id}")
    public String movieDetail(@PathVariable int id, Model model) {
        List<Movie> movies = getBestMovies();
        for (Movie movie : movies) {
            if (movie.getId() == id) {
                model.addAttribute("movie", movie);
                break;
            }
        }
        return "movieDetail";
    }

    @RequestMapping("/songs/{id}")
    public String songDetail(@PathVariable int id, Model model) {
        List<Song> songs = getBestSongs();
        for (Song song : songs) {
            if (song.getId() == id) {
                model.addAttribute("song", song);
                break;
            }
        }
        return "songDetail";
    }
}