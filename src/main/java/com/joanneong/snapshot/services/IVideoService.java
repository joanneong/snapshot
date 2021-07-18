package com.joanneong.snapshot.services;

import com.joanneong.snapshot.models.Video;

import java.util.Collection;
import java.util.Optional;

public interface IVideoService {
    Collection<Video> getAllVideos();

    Collection<Video> getVideosByIds(Collection<String> videoIds);

    Optional<Video> getVideoById(String videoId);

    Collection<Video> searchVideosByQuery(String searchQuery);

    Optional<Video> addVideo(Video video);

    Optional<Video> editVideo(Video video);

    void deleteVideo(Video video);
}
