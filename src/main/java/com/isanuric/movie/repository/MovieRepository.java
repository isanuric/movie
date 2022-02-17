package com.isanuric.movie.repository;

import com.isanuric.movie.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {

    List<Movie> findByName(final String name);

    Movie findById(final long id);
}
