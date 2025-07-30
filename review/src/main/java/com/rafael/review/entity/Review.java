package com.rafael.review.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Review {

    @Id
    private Long id;

    private Date date;
    private String comment;

    private Long userId;
    private Long movieId;

}
