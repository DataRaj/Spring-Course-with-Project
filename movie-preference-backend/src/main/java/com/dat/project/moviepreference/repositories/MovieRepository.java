package com.dat.project.moviepreference.repositories;

import com.dat.project.moviepreference.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
