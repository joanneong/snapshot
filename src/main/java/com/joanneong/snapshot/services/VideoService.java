package com.joanneong.snapshot.services;

import com.joanneong.snapshot.data.VideoRepository;
import com.joanneong.snapshot.models.Review;
import com.joanneong.snapshot.models.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class VideoService implements IVideoService {
    @Autowired
    VideoRepository videoRepository;

    @Autowired
    IYouTubeService youTubeService;

    @Override
    public Collection<Video> getAllVideos() {
        return (Collection<Video>) videoRepository.findAll();
    }

    @Override
    public Collection<Video> getVideosByIds(Collection<String> videoIds) {
        return (Collection<Video>) videoRepository.findAllById(videoIds);
    }

    @Override
    public Optional<Video> getVideoById(String videoId) {
        return videoRepository.findById(videoId);
    }

    @Override
    public Collection<Video> searchVideosByQuery(String searchQuery) {
        return youTubeService.searchVideosByQuery(searchQuery);
    }

    @Override
    public Optional<Video> addVideo(Video video) {
        Video savedVideo = videoRepository.findById(video.getId())
                .orElseGet(() -> videoRepository.save(video));
        return Optional.of(savedVideo);
    }

    @Override
    public Optional<Video> editVideo(Video video) {
        return videoRepository.findById(video.getId())
                .map(originalVideo -> {
                    originalVideo.setTitle(video.getTitle());
                    originalVideo.setThumbnailUrl(video.getThumbnailUrl());
                    originalVideo.setVideoType(video.getVideoType());
                    return videoRepository.save(originalVideo);
                })
                .map(Video.class::cast);
    }

    @Override
    public void deleteVideo(Video video) {
        videoRepository.delete(video);
    }
}
