package com.joanneong.snapshot.controllers;

import com.joanneong.snapshot.models.User;
import com.joanneong.snapshot.models.Video;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api")
public class VideoController {
    /**
     * Gets all videos currently saved in the database
     */
    @GetMapping("/videos")
    public Collection<Video> getAllVideos() {
        return null;
    }

    /**
     * Gets all videos filtered by keywords in a given search query
     */
    @GetMapping("/videos/search_query")
    public Collection<Video> searchVideosByQuery(@RequestParam("query") String searchQuery) {
        return null;
    }

    /**
     * Gets all videos filtered by a given user
     */
    @PostMapping("/videos/search_user")
    public Collection<Video> searchVideosByUser(@RequestBody User user) {
        return null;
    }

    /**
     * Saves a video's metadata to the database
     * This means that the video has at least one review associated with it
     */
    @PostMapping("/video/add_video")
    public void addVideo(@RequestBody Video video) {

    }

    /**
     * Edits a video's saved metadata in the database
     * This should not be called unless there are changes on Youtube's end
     */
    @PostMapping("/video/edit_video")
    public void editVideo(@RequestBody Video review) {

    }

    /**
     * Deletes a video saved in the database
     * This can be called when a video has no associated reviews to "purge" the
     * database
     */
    @PostMapping("/video/delete_video")
    public void deleteVideo(@RequestBody Video video) {

    }
}
