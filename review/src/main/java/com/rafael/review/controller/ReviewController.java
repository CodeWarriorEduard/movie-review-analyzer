package com.rafael.review.controller;

import com.rafael.review.dto.PostReviewDTO;
import com.rafael.review.entity.Review;
import com.rafael.review.service.interfaces.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Review>> getAllUserReviews(@PathVariable  Long userId) {
        return ResponseEntity.ok().body(reviewService.getReviewsByUserId(userId));
    }

    @PostMapping("/new")
    public ResponseEntity<Review> createReview(@RequestBody PostReviewDTO review) {
        return ResponseEntity.ok().body(reviewService.createReview(review));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Review>> getAllReviews() {
        return ResponseEntity.ok().body(reviewService.getAll());
    }

}
