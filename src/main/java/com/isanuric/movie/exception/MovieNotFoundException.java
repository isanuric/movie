package com.isanuric.movie.exception;

public class MovieNotFoundException extends RuntimeException {

    public MovieNotFoundException(Long id) {
        super(String.format("Movie not found. Id:%d", id));
    }
}
