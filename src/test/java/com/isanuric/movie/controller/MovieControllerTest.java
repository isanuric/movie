package com.isanuric.movie.controller;

import com.isanuric.movie.MovieApplicationTests;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.http.MediaType;

// use @BeforeAll and @AfterAll for non-static methods.
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MovieControllerTest extends MovieApplicationTests {

    @BeforeAll
    void setUp() {
        webTestClient.post()
                .uri("/movie")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue("{\"name\": \"AAA\", \"author\": \"BBB\", \"regisseur\": \"CCC\"}")
                .exchange()
                .expectStatus()
                .isOk();
    }

    @Test
    void findById() {
        webTestClient.get()
                .uri("/id/1")
                .exchange()
                .expectStatus()
                .isOk();
    }
}
