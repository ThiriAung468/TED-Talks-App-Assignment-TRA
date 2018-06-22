package com.padcmyanmar.ted.talks.assignment.tra.data.vos;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PodcastVO {

    @SerializedName("podcast_id")
    private int podcastId;

    @SerializedName("title")
    private String title;

    @SerializedName("imageUrl")
    private String imageUrl;

    @SerializedName("description")
    private String description;

    @SerializedName("segments")
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
