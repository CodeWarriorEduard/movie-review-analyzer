package com.rafael.movie.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Movie {

    @Id
    private Long id;
    private String title;
    private String description;
    private String director;
    private Integer duration;
    private String language;
    private String genre;
    private String country;
}
