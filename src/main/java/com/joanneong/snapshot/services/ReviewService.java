package com.joanneong.snapshot.services;

import com.joanneong.snapshot.data.ReviewRepository;
import com.joanneong.snapshot.models.Review;
import com.joanneong.snapshot.models.User;
import com.joanneong.snapshot.models.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class ReviewService implements IReviewService {
    @Autowired
    ReviewRepository reviewRepository;

    @Override
    public Collection<Double> getAvgRatings(Collection<Video> videos) {
        return videos.stream()
                .map(video -> reviewRepository.getAverageRatingForVideo(video.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Review> getReviews(String videoId) {
        return reviewRepository.findByVideoId(videoId);
    }

    @Override
    public Collection<Review> getReviewsByUser(User user) {
        return reviewRepository.findByCreator(user.getId());
    }

    @Override
    public Review addReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public void editReview(Review review) {
        reviewRepository.findById(review.getId())
                .ifPresent(originalReview -> {
                    originalReview.setTitle(review.getTitle());
                    originalReview.setContent(review.getContent());
                    originalReview.setRating(review.getRating());
                    originalReview.setLastModifiedOn(review.getLastModifiedOn());
                    reviewRepository.save(originalReview);
                });
    }

    @Override
    public void deleteReview(Review review) {
        reviewRepository.deleteById(review.getId());
    }
}
