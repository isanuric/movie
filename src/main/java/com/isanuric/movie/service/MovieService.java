package com.isanuric.movie.service;

import com.isanuric.movie.entity.Movie;
import com.isanuric.movie.repository.MovieRepository;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie save(final Movie movie) {
        return this.movieRepository.save(movie);
    }
}
