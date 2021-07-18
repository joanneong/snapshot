package com.joanneong.snapshot.data;

import com.joanneong.snapshot.SnapshotApplication;
import com.joanneong.snapshot.TestDataHelper;
import com.joanneong.snapshot.models.Review;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.joanneong.snapshot.TestDataHelper.INVALID_USER;
import static com.joanneong.snapshot.TestDataHelper.INVALID_VIDEO_ID;
import static com.joanneong.snapshot.TestDataHelper.TAKE_ME_TO_CHURCH_OFFICIAL;
import static com.joanneong.snapshot.TestDataHelper.TAKE_ME_TO_CHURCH_POP_UP;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest(classes=SnapshotApplication.class)
public class ReviewRepositoryTest {
    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    public void getAvgRatingsForVideoWithMultipleReviews_returnsAvgRating() {
        Double avgRating = reviewRepository.getAverageRatingForVideo(TAKE_ME_TO_CHURCH_OFFICIAL.getId());
        assertEquals(3.333, avgRating, 0.001);
    }

    @Test
    public void getAvgRatingsForVideoWithNoReviews_returnsNull() {
        assertNull(reviewRepository.getAverageRatingForVideo(TAKE_ME_TO_CHURCH_POP_UP.getId()));
    }

    @Test
    public void getReviewsForValidVideoId() {
        List<Review> reviews = reviewRepository.findByVideoId(TAKE_ME_TO_CHURCH_OFFICIAL.getId());
        assertNotNull(reviews);
        assertEquals(3, reviews.size());
    }

    @Test
    public void getReviewsForInvalidVideoId() {
        List<Review> reviews = reviewRepository.findByVideoId(INVALID_VIDEO_ID);
        assertNotNull(reviews);
        assertEquals(0, reviews.size());
    }

    @Test
    public void getReviewsForValidCreator() {
        List<Review> reviews = reviewRepository.findByUserId(TestDataHelper.VALID_USER.getId());
        assertNotNull(reviews);
        assertEquals(16, reviews.size());
    }

    @Test
    public void getReviewsForInvalidCreator() {
        List<Review> reviews = reviewRepository.findByUserId(INVALID_USER.getId());
        assertNotNull(reviews);
        assertEquals(0, reviews.size());
    }
}
