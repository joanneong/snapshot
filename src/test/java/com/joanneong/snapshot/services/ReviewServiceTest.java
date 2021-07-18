package com.joanneong.snapshot.services;

import com.joanneong.snapshot.data.ReviewRepository;
import com.joanneong.snapshot.models.Review;
import com.joanneong.snapshot.models.Video;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import static com.joanneong.snapshot.TestDataHelper.INVALID_USER;
import static com.joanneong.snapshot.TestDataHelper.LEMON_TREE_LYRICS;
import static com.joanneong.snapshot.TestDataHelper.LEMON_TREE_MUSIC;
import static com.joanneong.snapshot.TestDataHelper.TAKE_ME_TO_CHURCH_OFFICIAL;
import static com.joanneong.snapshot.TestDataHelper.TAKE_ME_TO_CHURCH_OFFICIAL_REVIEW_ONE;
import static com.joanneong.snapshot.TestDataHelper.TAKE_ME_TO_CHURCH_OFFICIAL_REVIEW_THREE;
import static com.joanneong.snapshot.TestDataHelper.TAKE_ME_TO_CHURCH_OFFICIAL_REVIEW_TWO;
import static com.joanneong.snapshot.TestDataHelper.TAKE_ME_TO_CHURCH_POP_UP;
import static com.joanneong.snapshot.TestDataHelper.VALID_USER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ReviewServiceTest {
    @Mock
    private ReviewRepository reviewRepository;

    @InjectMocks
    private ReviewService reviewService;

    @Test
    public void getAvgRatingsForVideosWithReviews_returnsRatings() {
        when(reviewRepository.getAverageRatingForVideo(TAKE_ME_TO_CHURCH_OFFICIAL.getId())).thenReturn(3.333);
        when(reviewRepository.getAverageRatingForVideo(LEMON_TREE_LYRICS.getId())).thenReturn(4.75);
        when(reviewRepository.getAverageRatingForVideo(LEMON_TREE_MUSIC.getId())).thenReturn(3.0);

        Collection<Double> expectedRatings = Arrays.asList(3.333, 4.75, 3.0);

        Collection<Video> allVideosWithReviews = Arrays.asList(
                TAKE_ME_TO_CHURCH_OFFICIAL,
                LEMON_TREE_LYRICS,
                LEMON_TREE_MUSIC
        );
        Collection<Double> avgRatings = reviewService.getAvgRatings(allVideosWithReviews);
        assertNotNull(avgRatings);
        assertEquals(3, avgRatings.size());
        assertCollectionOfDoublesEquals(expectedRatings, avgRatings);
    }

    @Test
    public void getAvgRatingsForVideosWithoutReviews_returnsRatings() {
        when(reviewRepository.getAverageRatingForVideo(TAKE_ME_TO_CHURCH_POP_UP.getId())).thenReturn(0.0);
        when(reviewRepository.getAverageRatingForVideo(LEMON_TREE_LYRICS.getId())).thenReturn(4.75);
        when(reviewRepository.getAverageRatingForVideo(LEMON_TREE_MUSIC.getId())).thenReturn(3.0);

        Collection<Double> expectedRatings = Arrays.asList(0.0, 4.75, 3.0);

        Collection<Video> allVideosWithReviews = Arrays.asList(
                TAKE_ME_TO_CHURCH_POP_UP,
                LEMON_TREE_LYRICS,
                LEMON_TREE_MUSIC
        );
        Collection<Double> avgRatings = reviewService.getAvgRatings(allVideosWithReviews);
        assertNotNull(avgRatings);
        assertEquals(3, avgRatings.size());
        assertCollectionOfDoublesEquals(expectedRatings, avgRatings);
    }

    @Test
    public void getReviewsForVideoWithReviews_returnsReviews() {
        List<Review> mockReviews = new ArrayList<>();
        mockReviews.add(TAKE_ME_TO_CHURCH_OFFICIAL_REVIEW_ONE);
        mockReviews.add(TAKE_ME_TO_CHURCH_OFFICIAL_REVIEW_TWO);
        mockReviews.add(TAKE_ME_TO_CHURCH_OFFICIAL_REVIEW_THREE);
        when(reviewRepository.findByVideoId(TAKE_ME_TO_CHURCH_OFFICIAL.getId())).thenReturn(mockReviews);

        Collection<Review> reviews = reviewService.getReviews(TAKE_ME_TO_CHURCH_OFFICIAL.getId());
        assertNotNull(reviews);
        assertEquals(3, reviews.size());
    }

    @Test
    public void getReviewsForVideoWithoutReviews_returnsNoReviews() {
        List<Review> mockReviews = new ArrayList<>();
        when(reviewRepository.findByVideoId(TAKE_ME_TO_CHURCH_POP_UP.getId())).thenReturn(mockReviews);

        Collection<Review> reviews = reviewService.getReviews(TAKE_ME_TO_CHURCH_POP_UP.getId());
        assertNotNull(reviews);
        assertEquals(0, reviews.size());
    }

    @Test
    public void getReviewsForValidUser_returnsReviews() {
        List<Review> mockReviews = new ArrayList<>();
        mockReviews.add(TAKE_ME_TO_CHURCH_OFFICIAL_REVIEW_ONE);
        mockReviews.add(TAKE_ME_TO_CHURCH_OFFICIAL_REVIEW_TWO);
        mockReviews.add(TAKE_ME_TO_CHURCH_OFFICIAL_REVIEW_THREE);
        when(reviewRepository.findByUserId(VALID_USER.getId())).thenReturn(mockReviews);

        Collection<Review> reviews = reviewService.getReviewsByUser(VALID_USER);
        assertNotNull(reviews);
        assertEquals(3, reviews.size());
    }

    @Test
    public void getReviewsForInvalidUser_returnsNoReviews() {
        List<Review> mockReviews = new ArrayList<>();
        when(reviewRepository.findByUserId(INVALID_USER.getId())).thenReturn(mockReviews);

        Collection<Review> reviews = reviewService.getReviewsByUser(INVALID_USER);
        assertNotNull(reviews);
        assertEquals(0, reviews.size());
    }

    @Test
    public void addReviewForExistingVideo_returnsAddedReview() {
        Review newReview = new Review(1L, 5.0, "Best MV ever",
                "I love this MV so much because there is so much going on here",
                LocalDateTime.now(), LocalDateTime.now(), VALID_USER, TAKE_ME_TO_CHURCH_OFFICIAL);
        when(reviewRepository.save(newReview)).thenReturn(newReview);

        Optional<Review> addedReview = reviewService.addReview(newReview);
        assertTrue(addedReview.isPresent());
        assertEquals(newReview, addedReview.get());
    }

    @Test
    public void editReviewForExistingVideo_returnsEditedReview() {
        Review newReview = new Review(1L, 5.0, "Best MV ever",
                "I love this MV so much because there is so much going on here",
                LocalDateTime.now(), LocalDateTime.now(), VALID_USER, TAKE_ME_TO_CHURCH_OFFICIAL);
        when(reviewRepository.findById(any())).thenReturn(Optional.of(newReview));
        when(reviewRepository.save(any())).thenReturn(newReview);

        Optional<Review> addedReview = reviewService.editReview(newReview);
        assertTrue(addedReview.isPresent());
        assertEquals(newReview, addedReview.get());
    }

    private static void assertCollectionOfDoublesEquals(Collection<Double> expectedCollection, Collection<Double> actualCollection) {
        Iterator<Double> expectedIterator = expectedCollection.iterator();
        for (Double element : actualCollection) {
            assertEquals(expectedIterator.next(), element, 0.001);
        }
        assertFalse(expectedIterator.hasNext());
    }
}
