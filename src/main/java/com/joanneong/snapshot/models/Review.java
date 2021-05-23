package com.joanneong.snapshot.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @Column(name = "review_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private int rating;

    @NotNull
    private String title;

    @NotNull
    private String content;

    @Column(name = "created_on")
    @NotNull
    private LocalDateTime createdOn;

    @Column(name = "last_modified_on")
    @NotNull
    private LocalDateTime lastModifiedOn;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @NotNull
    private User creator;

    public Review(Long id, @NotNull int rating, @NotNull String title, @NotNull String content,
                  @NotNull LocalDateTime createdOn, @NotNull LocalDateTime lastModifiedOn, @NotNull User creator) {
        this.id = id;
        this.rating = rating;
        this.title = title;
        this.content = content;
        this.createdOn = createdOn;
        this.lastModifiedOn = lastModifiedOn;
        this.creator = creator;
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

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Review review = (Review) o;
        return rating == review.rating
                && id.equals(review.id)
                && title.equals(review.title)
                && content.equals(review.content)
                && createdOn.equals(review.createdOn)
                && creator.equals(review.creator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rating, title, content, createdOn, creator);
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", rating=" + rating +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createdOn=" + createdOn +
                ", lastModifiedOn=" + lastModifiedOn +
                ", creator=" + creator.toString() +
                '}';
    }

}
