package com.isanuric.movie.controller;

import com.isanuric.movie.entity.Movie;
import com.isanuric.movie.repository.MovieRepository;
import com.isanuric.movie.service.MovieService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import static java.lang.String.*;

@RestController
public class MovieController {

    private MovieService movieService;
    private MovieRepository movieRepository;

    public MovieController(MovieService movieService, MovieRepository movieRepository) {
        this.movieService = movieService;
        this.movieRepository = movieRepository;
    }

    @GetMapping("/")
    public HashMap<String, String> root() {
        HashMap<String, String> map = new HashMap<>();
        map.put("message", "Welcome to movie API!");
        map.put("Date", valueOf(new Date()));
        return map;
    }

    @GetMapping("/status")
    public String getStatus() {
        return "OK";
    }

    @GetMapping("/{id}")
    public Movie findById(@PathVariable Long id) {
        return movieRepository.findById(id).get();
    }

    @PostMapping("/movie/save-random")
    public Movie same() {
        final var movie = new Movie();
        final var random = getRandomString().toUpperCase(Locale.ROOT);
        movie.setName("Name-" + random);
        movie.setAuthor("Autor-" + random);
        movie.setRegisseur("Regisseur-" + random);

        return this.movieService.save(movie);
    }

    private String getRandomString() {
        return RandomStringUtils.random(6, true, true);
    }
}
