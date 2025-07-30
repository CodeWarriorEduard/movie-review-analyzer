package com.rafael.movie.controller;

import com.rafael.movie.entity.Movie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {


    List<String> movies = List.of(
            "The Matrix",
            "Inception",
            "Interstellar",
            "The Godfather",
            "Pulp Fiction"
    );

    @GetMapping("/all")
    public List<String> getAllMovies() {
        return movies;
    }

}
