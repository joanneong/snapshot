package com.joanneong.snapshot.models;

/**
 * Describe the structure of a basic review
 */
public interface Review {
    /**
     * Get the unique identifier for a review
     * @return Long         unique identifier of review
     */
    Long getId();

    /**
     * Get the title of a review
     * @return String       title of review
     */
    String getTitle();

    /**
     * Get the content of a review
     * @return String       content of review
     */
    String getContent();
}
