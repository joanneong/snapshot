package com.joanneong.snapshot.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "videos")
public class Video {
    @Id
    @Column(name = "video_id")
    @NotNull
    private String id;

    @NotNull
    private String title;

    /**
     * Persist string representation of enum in database
     * instead of ordinal value (default) so that it is
     * safer to add and remove enum types
     */
    @Column(name = "video_type")
    @Enumerated(EnumType.STRING)
    @NotNull
    private VideoType videoType;

    @Column(name = "thumbnail_url")
    @NotNull
    private String thumbnailUrl;

    public Video(@NotNull String id, @NotNull String title, @NotNull VideoType videoType, @NotNull String thumbnailUrl) {
        this.id = id;
        this.title = title;
        this.videoType = videoType;
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public VideoType getVideoType() {
        return videoType;
    }

    public void setVideoType(VideoType videoType) {
        this.videoType = videoType;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Video video = (Video) o;
        return id.equals(video.id)
                && title.equals(video.title)
                && videoType == video.videoType
                && thumbnailUrl.equals(video.thumbnailUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, videoType, thumbnailUrl);
    }

    @Override
    public String toString() {
        return "Video{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", videoType=" + videoType +
                ", thumbnailUrl='" + thumbnailUrl +
                '}';
    }
}
