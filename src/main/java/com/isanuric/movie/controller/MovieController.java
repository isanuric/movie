package com.isanuric.movie.controller;

import com.isanuric.movie.entity.Movie;
import com.isanuric.movie.repository.MovieRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

import static java.lang.String.valueOf;

@RestController
public class MovieController {

    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping("/")
    public Map<String, String> root() {
        Map<String, String> map = new HashMap<>();
        map.put("message", "Welcome to movie API!");
        map.put("Date", valueOf(new Date()));
        return map;
    }

    @GetMapping("/status")
    public String getStatus() {
        return "OK";
    }

    @GetMapping("/id/{id}")
    public Optional<Movie> findById(@PathVariable Long id) {
        return movieRepository.findById(id);
    }

    @GetMapping("/id/delete/{id}")
    public void deleteById(@PathVariable Long id) {
         movieRepository.deleteById(id);
    }

    @GetMapping("/name/{name}")
    public List<Movie> findByName(@PathVariable String name) {
        return movieRepository.findByName(name);
    }

    @GetMapping("/author/{author}")
    public List<Movie> findByAuthor(@PathVariable String author) {
        return movieRepository.findByAuthor(author);
    }

    @GetMapping("/regisseur/{regisseur}")
    public List<Movie> findByRegisseur(@PathVariable String regisseur) {
        return movieRepository.findByRegisseur(regisseur);
    }

    @GetMapping("/all")
    public Iterable<Movie> findAll() {
        return movieRepository.findAll();
    }

    @PostMapping("/create")
    // public Movie create(@ModelAttribute Movie movie) {
    public Movie create(@RequestBody Movie movie) {
        return this.movieRepository.save(movie);
    }

    @PostMapping("/create-random")
    public Movie createRandom() {
        final var random = getRandomString().toUpperCase(Locale.ROOT);
        final var movie = new Movie("Name" + random, "Author" + random, "Regisseur" + random);

        return this.movieRepository.save(movie);
    }

    private String getRandomString() {
        return RandomStringUtils.random(6, true, true);
    }
}
