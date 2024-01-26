package com.dat.project.moviepreference.controllers;

import com.dat.project.moviepreference.dto.MovieDTO;
import com.dat.project.moviepreference.dto.ScoreDTO;
import com.dat.project.moviepreference.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequestMapping(value = "/scores")
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    @PutMapping
    public MovieDTO SaveScore(@RequestBody ScoreDTO dto){
        MovieDTO movieDTO = scoreService.saveSCore(dto);
        return movieDTO;
    }
}
