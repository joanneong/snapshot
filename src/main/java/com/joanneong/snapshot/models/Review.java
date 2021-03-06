package com.joanneong.snapshot.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
    private Double rating;

    @NotNull
    private String title;

    @NotNull
    @Lob
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
    private User user;

    @ManyToOne
    @JoinColumn(name = "video_id")
    @NotNull
    private Video video;

    /**
     * Default constructor needed as Hibernate creates a bean via reflection
     * by calling the default constructor and then setter methods to set properties
     */
    public Review() {

    }

    public Review(Long id, @NotNull double rating, @NotNull String title, @NotNull String content,
                  @NotNull LocalDateTime createdOn, @NotNull LocalDateTime lastModifiedOn, @NotNull User user,
                  @NotNull Video video) {
        this.id = id;
        this.rating = rating;
        this.title = title;
        this.content = content;
        this.createdOn = createdOn;
        this.lastModifiedOn = lastModifiedOn;
        this.user = user;
        this.video = video;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
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
                && user.equals(review.user)
                && video.equals(review.video);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rating, title, content, createdOn, user, video);
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", rating=" + rating +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createdOn=" + createdOn + '\'' +
                ", lastModifiedOn=" + lastModifiedOn + '\'' +
                ", creator=" + user.toString() + '\'' +
                ", video=" + video.toString() +
                '}';
    }
}
