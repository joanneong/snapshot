package com.joanneong.snapshot.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class MusicVideoReview implements Review {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String title;

    private String content;

    private String musicVideoId;

    MusicVideoReview(Long id, String title, String content, String musicVideoId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.musicVideoId = musicVideoId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getMusicVideoId() {
        return musicVideoId;
    }

    public void setMusicVideoId(String musicVideoId) {
        this.musicVideoId = musicVideoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof MusicVideoReview)) {
            return false;
        }

        MusicVideoReview musicVideoReview = (MusicVideoReview) o;

        return Objects.equals(this.id, musicVideoReview.id)
                && Objects.equals(this.title, musicVideoReview.title)
                && Objects.equals(this.content, musicVideoReview.content)
                && Objects.equals(this.musicVideoId, musicVideoReview.musicVideoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.title, this.content, this.musicVideoId);
    }

    @Override
    public String toString() {
        return "MusicVideoReview{"
                + "id=" + this.id
                + ", title='" + this.title + '\''
                + ", musicVideoId='" + this.musicVideoId + '\''
                + '}';    }
}
