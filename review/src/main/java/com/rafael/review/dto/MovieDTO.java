package com.rafael.review.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO {
    Long id;
    String title;
    String description;
    String director;
    Integer duration;
    String language;
    String genre;
    String country;
}
