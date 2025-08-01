package com.rafael.review.service.impl;

import com.rafael.review.dto.PostReviewDTO;
import com.rafael.review.dto.UserDTO;
import com.rafael.review.entity.Review;
import com.rafael.review.exception.ReviewNotFoundException;
import com.rafael.review.exception.UserNotFoundException;
import com.rafael.review.repository.ReviewRepository;
import com.rafael.review.service.interfaces.ReviewService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final RestTemplate restTemplate;


    // Service uri
    @Value("${service.user.location}")
    private String userServiceLocation;
    @Value("${service.movie.location}")
    private String movieServiceLocation;

    public ReviewServiceImpl(ReviewRepository reviewRepository, RestTemplate restTemplate) {
        this.reviewRepository = reviewRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Review> getReviewsByUserId(Long userId) {
        /*
        * 1) Look if the user with the given id exists
        * 2) Make a request to review_db and filter by this id if exists.
        * */

        try{
            restTemplate.getForEntity(userServiceLocation+"/"+userId, UserDTO.class);
        }catch (HttpClientErrorException.NotFound e){
            if(e.getStatusCode().equals(HttpStatus.NOT_FOUND)){
                throw new UserNotFoundException("User not found");
            }
        }

        return reviewRepository.findAllByUserId(userId);
    }

    @Override
    public Review getReviewById(Long reviewId) {
        return reviewRepository.findById(reviewId)
                .orElseThrow(() -> new ReviewNotFoundException("Review not found"));
    }

    @Override
    public Review createReview(PostReviewDTO review) {

        /*
         * Who is creating the review? and Which one is the movie we want to review?
         * 1) Let's verify the user that is going to post the review exists
         * 2) Verify the movie we want to review exists
         * 3)
         */

        try{ // Duplicated code, fix later
            restTemplate.getForEntity(userServiceLocation+"/"+review.getUserId(), UserDTO.class);
        }catch (HttpClientErrorException.NotFound e){
            if(e.getStatusCode().equals(HttpStatus.NOT_FOUND)){
                throw new UserNotFoundException("User not found");
            }
        }




        return null;
    }

    @Override
    public Review updateReview(Review review) {
        return null;
    }

    @Override
    public void deleteReviewById(Long reviewId) {

    }
}
