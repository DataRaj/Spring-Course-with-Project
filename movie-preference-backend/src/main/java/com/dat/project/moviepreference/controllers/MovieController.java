package com.dat.project.moviepreference.controllers;


import com.dat.project.moviepreference.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequestMapping(value = "/movie")
public class MovieController {

    @Autowired
    private MovieService service;
}
