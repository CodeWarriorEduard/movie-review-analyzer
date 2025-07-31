package com.rafael.movie.service.impl;

import com.rafael.movie.entity.Movie;
import com.rafael.movie.exception.MovieNotFoundException;
import com.rafael.movie.repository.MovieRepository;
import com.rafael.movie.service.interfaces.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> findAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie findMovieById(Long id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException(id));
    }

    @Override
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie updateMovie(Movie movie, Long id) {

        Movie movie1 = findMovieById(id);

        if(movie1.getCountry() != null) {
            movie1.setCountry(movie.getCountry());
        } else if (movie1.getGenre() != null) {
            movie1.setGenre(movie.getGenre());
        }else if (movie1.getDirector() != null) {
            movie1.setDirector(movie.getDirector());
        } else if (movie1.getTitle() != null) {
            movie1.setTitle(movie.getTitle());
        } else if (movie1.getDescription() != null) {
            movie1.setDescription(movie.getDescription());
        }else if(movie1.getDuration()!=null){
            movie1.setDuration(movie.getDuration());
        } else if (movie1.getLanguage() != null) {
            movie1.setLanguage(movie.getLanguage());
        }

        movieRepository.save(movie1);

        return movie1;
    }

    @Override
    public void deleteMovie(Long id) {
        Movie movie =  findMovieById(id);
        movieRepository.delete(movie);
    }
}
