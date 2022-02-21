package com.isanuric.movie.controller;

import com.isanuric.movie.entity.Movie;
import com.isanuric.movie.exception.MovieNotFoundException;
import com.isanuric.movie.repository.MovieRepository;
import com.isanuric.movie.service.PdfService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.core.io.InputStreamResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static java.lang.String.valueOf;

@RestController
public class MovieController {

    private final MovieRepository movieRepository;
    private final PdfService pdfService;

    public MovieController(MovieRepository movieRepository, PdfService pdfService) {
        this.movieRepository = movieRepository;
        this.pdfService = pdfService;
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
    public Movie findById(@PathVariable Long id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException(id));
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

    @GetMapping("/movie")
    public Iterable<Movie> findAll() {
        return movieRepository.findAll();
    }

    @PostMapping("/movie")
    public Movie create(@RequestBody @Valid Movie movie) {
        return this.movieRepository.save(movie);
    }


    @PostMapping("/movie-string")
    public Mono<String> getTextString() {
        return pdfService.getTest();
    }

    // TODO: 21.02.22
    @PostMapping("/movie-pdf")
    public Mono<InputStreamResource> createMoviePdf() {

        final Mono<InputStreamResource> pdf = pdfService.getPdf();
        return pdf;
    }

    private String getRandomString() {
        return RandomStringUtils.random(6, true, true);
    }
}
