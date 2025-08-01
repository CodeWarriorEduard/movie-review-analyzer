package com.rafael.review.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PostReviewDTO {

    Long userId;
    Long movieId;

    Date reviewDate;
    String content;


}
