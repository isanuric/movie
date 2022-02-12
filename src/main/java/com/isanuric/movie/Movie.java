package com.isanuric.movie;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Movie {

    @GetMapping("/status")
    public String getStatus() {
        return "OK";
    }
}
