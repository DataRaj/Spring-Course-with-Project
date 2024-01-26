package com.dat.project.moviepreference.services;

import com.dat.project.moviepreference.dto.MovieDTO;
import com.dat.project.moviepreference.entities.Movie;
import com.dat.project.moviepreference.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    @Transactional(readOnly = true)
    public Page<MovieDTO> findAll(Pageable pageable){
    Page<Movie> result = movieRepository.findAll(pageable);
    Page<MovieDTO> page = result.map(x -> new MovieDTO(x));
    return page;
    }

    @Transactional(readOnly = true)
    public MovieDTO findById(Long id){
        Movie result = movieRepository.findById(id).get();
        MovieDTO dto = new MovieDTO(result);
        return dto;
    }
}
