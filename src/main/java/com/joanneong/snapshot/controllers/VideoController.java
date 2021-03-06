package com.joanneong.snapshot.controllers;

import com.joanneong.snapshot.models.Video;
import com.joanneong.snapshot.services.IVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class VideoController {
    @Autowired
    IVideoService videoService;

    /**
     * Gets all videos currently saved in the database
     */
    @GetMapping("/videos")
    public Collection<Video> getAllVideos() {
        return videoService.getAllVideos();
    }

    /**
     * Gets all videos for a given list of video ids
     */
    @GetMapping("/videos/search_ids")
    public Collection<Video> getVideosByIds(@RequestBody Collection<String> videoIds) {
        return videoService.getVideosByIds(videoIds);
    }

    /**
     * Gets all videos filtered by keywords in a given search query
     */
    @GetMapping("/videos/search_query")
    public Collection<Video> searchVideosByQuery(@RequestParam("query") String searchQuery) {
        return videoService.searchVideosByQuery(searchQuery);
    }

    /**
     * Saves a video's metadata to the database
     * This means that the video has at least one review associated with it
     */
    @PostMapping("/video/add_video")
    public Optional<Video> addVideo(@RequestBody Video video) {
        return videoService.addVideo(video);
    }

    /**
     * Edits a video's saved metadata in the database
     * This should not be called unless there are changes on Youtube's end
     */
    @PostMapping("/video/edit_video")
    public Optional<Video> editVideo(@RequestBody Video video) {
        return videoService.editVideo(video);
    }

    /**
     * Deletes a video saved in the database
     * This can be called when a video has no associated reviews to "purge" the
     * database
     */
    @PostMapping("/video/delete_video")
    public void deleteVideo(@RequestBody Video video) {
        videoService.deleteVideo(video);
    }
}
