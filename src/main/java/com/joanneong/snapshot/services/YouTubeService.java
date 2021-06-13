package com.joanneong.snapshot.services;

import com.joanneong.snapshot.models.Video;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Service to interact with YouTube API
 */
@Service
public class YouTubeService implements IYouTubeService {
    @Override
    public Collection<Video> searchVideosByQuery(String searchQuery) {
        //TODO
        return null;
    }
}
