package com.joanneong.snapshot.data;

import com.joanneong.snapshot.models.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends PagingAndSortingRepository<Review, Long> {
    @Query("SELECT AVG(r.rating) FROM Review r WHERE r.video = :videoId")
    Double getAverageRatingForVideo(@Param("videoId") String videoId);

    List<Review> findByVideoId(String videoId);

    List<Review> findByCreator(Long userId);
}
