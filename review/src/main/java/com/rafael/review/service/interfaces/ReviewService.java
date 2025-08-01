package com.rafael.review.service.interfaces;

import com.rafael.review.dto.PostReviewDTO;
import com.rafael.review.entity.Review;

import java.util.List;

public interface ReviewService {

    List<Review> getReviewsByUserId(Long userId);
    Review getReviewById(Long reviewId);
    Review createReview(PostReviewDTO review);
    Review updateReview(Review review);
    void deleteReviewById(Long reviewId);
    List<Review> getAll();
}
