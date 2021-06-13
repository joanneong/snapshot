package com.joanneong.snapshot.services;

import com.joanneong.snapshot.models.Video;

import java.util.Collection;

public interface IYouTubeService {
    Collection<Video> searchVideosByQuery(String searchQuery);
}
