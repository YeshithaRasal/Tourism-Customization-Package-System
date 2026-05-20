package com.tourism.controller;

import com.tourism.config.UserDetailsImpl;
import com.tourism.dto.ReviewRequest;
import com.tourism.model.Booking;
import com.tourism.model.Review;
import com.tourism.model.User;
import com.tourism.repository.BookingRepository;
import com.tourism.repository.ReviewRepository;
import com.tourism.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    UserRepository userRepository;

    @PostMapping
    public Review submitReview(@RequestBody ReviewRequest request, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        User user = userRepository.findById(userDetails.getId()).orElseThrow();
        Booking booking = bookingRepository.findById(request.getBookingId()).orElseThrow();

        Review review = Review.builder()
                .user(user)
                .booking(booking)
                .rating(request.getRating())
                .comment(request.getComment())
                .build();

        return reviewRepository.save(review);
    }

    @GetMapping
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @GetMapping("/id/{id}")
    public Review getReviewById(@PathVariable Long id) {
        return reviewRepository.findById(id).orElseThrow(() -> new RuntimeException("Review not found"));
    }

    @GetMapping("/destination/{destinationId}")
    public List<Review> getReviewsByDestination(@PathVariable Long destinationId) {
        return reviewRepository.findByDestinationId(destinationId);
    }

    @PutMapping("/{id}")
    public Review updateReview(@PathVariable Long id, @RequestBody ReviewRequest request) {
        Review review = reviewRepository.findById(id).orElseThrow(() -> new RuntimeException("Review not found"));
        review.setRating(request.getRating());
        review.setComment(request.getComment());
        return reviewRepository.save(review);
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable Long id) {
        reviewRepository.deleteById(id);
    }
}
