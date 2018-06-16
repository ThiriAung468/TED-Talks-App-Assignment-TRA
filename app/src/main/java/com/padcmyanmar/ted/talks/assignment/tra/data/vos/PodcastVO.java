package com.padcmyanmar.ted.talks.assignment.tra.data.vos;

import java.util.List;

public class PodcastVO {
    private int podcastId;
    private String title;
    private String imageUrl;
    private String description;
    private List<SegmentVO> segment;

    public int getPodcastId() {
        return podcastId;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public List<SegmentVO> getSegment() {
        return segment;
    }
}
