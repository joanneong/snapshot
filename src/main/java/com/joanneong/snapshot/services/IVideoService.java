package com.joanneong.snapshot.services;

import com.joanneong.snapshot.models.Video;

import java.util.Collection;

public interface IVideoService {
    Collection<Video> getAllVideos();

    Collection<Video> getVideosByIds(Collection<String> videoIds);

    Collection<Video> searchVideosByQuery(String searchQuery);

    Video addVideo(Video video);

    void editVideo(Video video);

    void deleteVideo(Video video);
}
