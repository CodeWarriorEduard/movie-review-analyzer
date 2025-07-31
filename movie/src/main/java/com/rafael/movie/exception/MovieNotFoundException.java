package com.rafael.movie.exception;

public class MovieNotFoundException extends RuntimeException {
    public MovieNotFoundException(Long id) {
        super("Movie with id " + id + " not found");
    }
}
