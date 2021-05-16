package com.joanneong.snapshot.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("music_video")
@Table(name = "music_video_reviews")
public class MusicVideoReview extends Review {

    @ManyToOne
    @JoinColumn(name = "music_video_id")
    private MusicVideo musicVideo;

    MusicVideoReview(Long id, int rating, String title, String content, MusicVideo musicVideo) {
        super(id, rating, title, content);
        this.musicVideo = musicVideo;
    }

    public MusicVideo getMusicVideo() {
        return musicVideo;
    }

    public void setMusicVideo(MusicVideo musicVideo) {
        this.musicVideo = musicVideo;
    }
}
