package com.rafael.movie.service.interfaces;


import com.rafael.movie.entity.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> findAllMovies();
    Movie findMovieById(Long id);
    Movie saveMovie(Movie movie);
    Movie updateMovie(Movie movie, Long id);
    void deleteMovie(Long id);
}
