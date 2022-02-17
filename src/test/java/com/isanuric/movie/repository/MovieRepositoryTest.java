package com.isanuric.movie.repository;

import com.isanuric.movie.MovieApplicationTests;
import com.isanuric.movie.entity.Movie;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MovieRepositoryTest extends MovieApplicationTests {

    @BeforeEach
    void setup() {
        movieRepository.save(new Movie("Taxi Driver", "Paul Schrader", "Martin Scorsese"));
    }

    @AfterEach
    void teardown() {
        movieRepository.deleteAll();
    }

    @Test
    void findById() {
        Movie movie = movieRepository.findById(1);
        assertEquals("Taxi Driver", movie.getName());
        assertEquals("Paul Schrader", movie.getAuthor());
        assertEquals("Martin Scorsese", movie.getRegisseur());
    }

}
