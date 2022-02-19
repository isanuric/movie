package com.isanuric.movie.controller;

import com.isanuric.movie.MovieApplicationTests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

class MovieControllerTest extends MovieApplicationTests {

    @BeforeEach
    void setUp() {
        webTestClient.post()
                .uri("/create")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue("{\"name\": \"AAA\", \"author\": \"BBB\", \"regisseur\": \"CCC\"}")
                .exchange()
                .expectStatus()
                .isOk();
    }

    @Test
    void findById() throws InterruptedException {
        webTestClient.get()
                .uri("/id/1")
                .exchange()
                .expectStatus()
                .isOk();
    }
}
