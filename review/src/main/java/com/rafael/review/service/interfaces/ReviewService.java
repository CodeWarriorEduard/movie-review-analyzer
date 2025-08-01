package com.rafael.review.service.interfaces;

import com.rafael.review.entity.Review;

import java.util.List;

public interface ReviewService {

    List<Review> getReviewsByUserId(Long userId);
    Review getReviewById(Long reviewId);
    Review createReview(Review review);
    Review updateReview(Review review);
    void deleteReviewById(Long reviewId);

}
