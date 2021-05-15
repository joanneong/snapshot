package com.joanneong.snapshot;

import com.joanneong.snapshot.models.Review;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("/api")
public class ReviewController {
    @GetMapping("/reviews")
    Collection<Review> getAllReviews() {
        return null;
    }

    @GetMapping("/review/{id}")
    Review getReview(@PathVariable Long id) {
        return null;
    }

    @PostMapping("/review")
    Review addReview(@Valid @RequestBody Review review) {
        return null;
    }

    @PutMapping("/review")
    Review editReview(@Valid @RequestBody Review review) {
        return null;
    }

    @DeleteMapping("/review/{id}")
    void deleteReview(@PathVariable Long id) { }
}
