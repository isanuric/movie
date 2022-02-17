package com.isanuric.movie;

import com.isanuric.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("tests")
public class MovieApplicationTests {

    @Autowired
    public MovieRepository movieRepository;

}
