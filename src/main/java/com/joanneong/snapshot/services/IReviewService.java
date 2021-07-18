package com.joanneong.snapshot.services;

import com.joanneong.snapshot.models.Review;
import com.joanneong.snapshot.models.User;
import com.joanneong.snapshot.models.Video;

import java.util.Collection;
import java.util.Optional;

public interface IReviewService {
    Collection<Double> getAvgRatings(Collection<Video> videos);

    Collection<Review> getReviews(String videoId);

    Collection<Review> getReviewsByUser(User user);

    Optional<Review> addReview(Review review);

    Optional<Review> editReview(Review review);

    void deleteReview(Review review);
}
