package com.joanneong.snapshot.services;

import com.joanneong.snapshot.models.Review;
import com.joanneong.snapshot.models.User;
import com.joanneong.snapshot.models.Video;

import java.util.Collection;

public interface IReviewService {
    Collection<Double> getAvgRatings(Collection<Video> videos);

    Collection<Review> getReviews(String videoId);

    Collection<Review> getReviewsByUser(User user);

    Review addReview(Review review);

    void editReview(Review review);

    void deleteReview(Review review);
}
