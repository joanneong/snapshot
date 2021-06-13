package com.joanneong.snapshot.data;

import com.joanneong.snapshot.models.Video;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface VideoRepository extends PagingAndSortingRepository<Video, String> {
}
