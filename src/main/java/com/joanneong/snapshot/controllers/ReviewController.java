package com.joanneong.snapshot.controllers;

import com.joanneong.snapshot.models.Review;
import com.joanneong.snapshot.models.Video;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api")
public class ReviewController {
    /**
     * Gets the average ratings for a given list of videos
     * Returns null for videos with no ratings yet
     */
    @PostMapping(
            value = "/reviews/get_avg_ratings/",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public Collection<Long> getAvgRatings(@RequestBody Collection<Video> videos) {
        return null;
    }

    /**
     * Gets all the reviews associated with a video
     */
    @GetMapping("/reviews")
    public Collection<Review> getReviews(@RequestParam("video") String videoId) {
        return null;
    }

    /**
     * Saves a review to the database
     */
    @PostMapping("/review/add_review")
    public void addReview(@RequestBody Review review) {

    }

    /**
     * Edits a review in the database
     */
    @PostMapping("/review/edit_review")
    public void editReview(@RequestBody Review review) {

    }

    /**
     * Deletes a review from the database
     */
    @PostMapping("/review/delete_review")
    public void deleteReview(@RequestBody Review review) {

    }
}
