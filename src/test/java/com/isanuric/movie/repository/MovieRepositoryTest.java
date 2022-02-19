package com.isanuric.movie.repository;

import com.isanuric.movie.entity.Movie;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class MovieRepositoryTest {

    @Autowired
    private MovieRepository movieRepository;

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
