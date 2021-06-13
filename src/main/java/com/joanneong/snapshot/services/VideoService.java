package com.joanneong.snapshot.services;

import com.joanneong.snapshot.data.VideoRepository;
import com.joanneong.snapshot.models.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

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
    public Collection<Video> searchVideosByQuery(String searchQuery) {
        return youTubeService.searchVideosByQuery(searchQuery);
    }

    @Override
    public Video addVideo(Video video) {
        return videoRepository.findById(video.getId())
                .orElseGet(() -> videoRepository.save(video));
    }

    @Override
    public void editVideo(Video video) {
        videoRepository.findById(video.getId())
                .ifPresent(originalVideo -> {
                    originalVideo.setTitle(video.getTitle());
                    originalVideo.setThumbnailUrl(video.getThumbnailUrl());
                    originalVideo.setVideoType(video.getVideoType());
                    videoRepository.save(originalVideo);
                });
    }

    @Override
    public void deleteVideo(Video video) {
        videoRepository.delete(video);
    }
}
