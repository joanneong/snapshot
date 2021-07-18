package com.joanneong.snapshot.services;

import com.joanneong.snapshot.data.VideoRepository;
import com.joanneong.snapshot.models.Video;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import static com.joanneong.snapshot.TestDataHelper.LEMON_TREE_LYRICS;
import static com.joanneong.snapshot.TestDataHelper.LEMON_TREE_MUSIC;
import static com.joanneong.snapshot.TestDataHelper.TAKE_ME_TO_CHURCH_OFFICIAL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class VideoServiceTest {
    @Mock
    private VideoRepository videoRepository;

    @Mock
    private IYouTubeService youTubeService;

    @InjectMocks
    private VideoService videoService;

    @Test
    public void getAllVideos_returnsVideos() {
        Collection<Video> allVideos = new ArrayList<>();
        allVideos.add(TAKE_ME_TO_CHURCH_OFFICIAL);
        allVideos.add(LEMON_TREE_LYRICS);
        allVideos.add(LEMON_TREE_MUSIC);
        when(videoRepository.findAll()).thenReturn(allVideos);

        Collection<Video> videos = videoService.getAllVideos();
        assertEquals(allVideos, videos);
    }

    @Test
    public void getAllVideos_returnsEmptyList() {
        Collection<Video> allVideos = new ArrayList<>();
        when(videoRepository.findAll()).thenReturn(allVideos);

        Collection<Video> videos = videoService.getAllVideos();
        assertEquals(allVideos, videos);
    }

    @Test
    public void getVideosByIdsForMultipleIds_returnsVideos() {
        Collection<String> videoIds = new ArrayList<>();
        videoIds.add(TAKE_ME_TO_CHURCH_OFFICIAL.getId());
        videoIds.add(LEMON_TREE_MUSIC.getId());
        videoIds.add(LEMON_TREE_LYRICS.getId());

        Collection<Video> videos = new ArrayList<>();
        videos.add(TAKE_ME_TO_CHURCH_OFFICIAL);
        videos.add(LEMON_TREE_MUSIC);
        videos.add(LEMON_TREE_LYRICS);

        when(videoRepository.findAllById(videoIds)).thenReturn(videos);

        Collection<Video> allVideos = videoService.getVideosByIds(videoIds);
        assertEquals(videos, allVideos);
    }

    @Test
    public void getVideosByIdsForMultipleIds_returnsSomeNulls() {
        Collection<String> videoIds = new ArrayList<>();
        videoIds.add(TAKE_ME_TO_CHURCH_OFFICIAL.getId());
        videoIds.add(LEMON_TREE_MUSIC.getId());
        videoIds.add("invalid_video_id");

        Collection<Video> videos = new ArrayList<>();
        videos.add(TAKE_ME_TO_CHURCH_OFFICIAL);
        videos.add(LEMON_TREE_MUSIC);
        videos.add(null);

        when(videoRepository.findAllById(videoIds)).thenReturn(videos);

        Collection<Video> allVideos = videoService.getVideosByIds(videoIds);
        assertEquals(videos, allVideos);
    }

    @Test
    public void getVideoByIdForValidVideo_returnsVideo() {
        when(videoRepository.findById(TAKE_ME_TO_CHURCH_OFFICIAL.getId())).thenReturn(Optional.of(TAKE_ME_TO_CHURCH_OFFICIAL));

        Optional<Video> video = videoService.getVideoById(TAKE_ME_TO_CHURCH_OFFICIAL.getId());
        assertTrue(video.isPresent());
        assertEquals(TAKE_ME_TO_CHURCH_OFFICIAL, video.get());
    }

    @Test
    public void getVideoForInvalidVideo_returnsEmptyOptional() {
        when(videoRepository.findById("invalid_video_id")).thenReturn(Optional.empty());

        Optional<Video> video = videoService.getVideoById("invalid_video_id");
        assertFalse(video.isPresent());
        assertTrue(video.isEmpty());
    }

    @Test
    public void searchVideosByQuery_returnsVideos() {
        Collection<Video> videos = new ArrayList<>();
        videos.add(TAKE_ME_TO_CHURCH_OFFICIAL);
        videos.add(LEMON_TREE_MUSIC);
        videos.add(LEMON_TREE_LYRICS);

        when(youTubeService.searchVideosByQuery(any())).thenReturn(videos);

        Collection<Video> searchedVideos = videoService.searchVideosByQuery("church lemon");
        assertEquals(videos, searchedVideos);
    }

    @Test
    public void searchVideosByQuery_returnsEmptyList() {
        Collection<Video> videos = new ArrayList<>();

        when(youTubeService.searchVideosByQuery(any())).thenReturn(videos);

        Collection<Video> searchedVideos = videoService.searchVideosByQuery("church lemon");
        assertNotNull(searchedVideos);
        assertEquals(0, searchedVideos.size());
    }

    @Test
    public void addNewVideo_returnsNewVideo() {
        when(videoRepository.findById(TAKE_ME_TO_CHURCH_OFFICIAL.getId())).thenReturn(Optional.empty());
        when(videoRepository.save(any())).thenReturn(TAKE_ME_TO_CHURCH_OFFICIAL);

        Optional<Video> addedVideo = videoService.addVideo(TAKE_ME_TO_CHURCH_OFFICIAL);
        assertTrue(addedVideo.isPresent());
        assertEquals(TAKE_ME_TO_CHURCH_OFFICIAL, addedVideo.get());
    }

    @Test
    public void addExistingVideo_returnsExistingVideo() {
        when(videoRepository.findById(LEMON_TREE_LYRICS.getId())).thenReturn(Optional.of(LEMON_TREE_LYRICS));

        Optional<Video> addedVideo = videoService.addVideo(LEMON_TREE_LYRICS);
        assertTrue(addedVideo.isPresent());
        assertEquals(LEMON_TREE_LYRICS, addedVideo.get());
    }

    @Test
    public void editExistingVideo_returnsEditedVideo() {
        when(videoRepository.findById(any())).thenReturn(Optional.of(TAKE_ME_TO_CHURCH_OFFICIAL));
        when(videoRepository.save(any())).thenReturn(TAKE_ME_TO_CHURCH_OFFICIAL);

        Optional<Video> addedVideo= videoService.editVideo(TAKE_ME_TO_CHURCH_OFFICIAL);
        assertTrue(addedVideo.isPresent());
        assertEquals(TAKE_ME_TO_CHURCH_OFFICIAL, addedVideo.get());
    }
}
