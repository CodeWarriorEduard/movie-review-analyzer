package com.rafael.movie.controller;

import com.rafael.movie.entity.Movie;
import com.rafael.movie.service.interfaces.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Movie>> getAllMovies() {
        return ResponseEntity.ok().body(movieService.findAllMovies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable Long id) {
        return ResponseEntity.ok().body(movieService.findMovieById(id));
    }

    @PostMapping("/")
    public ResponseEntity<Movie>  createMovie(@RequestBody Movie movie) {
        return ResponseEntity.ok().body(movieService.saveMovie(movie));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody Movie movie) {
        return ResponseEntity.ok().body(movieService.saveMovie(movie));
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
        ResponseEntity.noContent().build();
    }

}
