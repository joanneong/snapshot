package com.joanneong.snapshot.models;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "review_type")
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private int rating;

    private String title;

    private String content;

    @Column(name = "created_on")
    private LocalDateTime createdOn;

    @Column(name = "last_modified_on")
    private LocalDateTime lastModifiedOn;

    Review(Long id, int rating, String title, String content) {
        this.id = id;
        this.rating = rating;
        this.title = title;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDateTime getLastModifiedOn() {
        return lastModifiedOn;
    }

    public void setLastModifiedOn(LocalDateTime lastModifiedOn) {
        this.lastModifiedOn = lastModifiedOn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Review)) {
            return false;
        }

        Review review = (Review) o;

        return Objects.equals(this.id, review.id)
                && Objects.equals(this.rating, review.rating)
                && Objects.equals(this.title, review.title)
                && Objects.equals(this.content, review.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.rating, this.title, this.content);
    }

    @Override
    public String toString() {
        return "Review={"
                + " id='" + this.id + '\''
                + " rating='" + this.rating + '\''
                + " title='" + this.title + '\''
                + " content='" + this.content + '\''
                + " created on='" + this.createdOn + '\''
                + " last modified on='" + this.lastModifiedOn + '\''
                + '}';
    }
}
