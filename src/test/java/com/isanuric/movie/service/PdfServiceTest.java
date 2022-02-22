package com.isanuric.movie.service;

import com.isanuric.movie.MovieApplicationTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class PdfServiceTest extends MovieApplicationTests {

    @Autowired
    private PdfService pdfService;

    @Test
    void fluxValues() {
        pdfService.fluxValues();
    }
}
