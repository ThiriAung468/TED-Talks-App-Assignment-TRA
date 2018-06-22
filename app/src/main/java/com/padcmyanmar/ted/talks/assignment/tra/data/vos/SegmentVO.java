package com.padcmyanmar.ted.talks.assignment.tra.data.vos;

import com.google.gson.annotations.SerializedName;

public class SegmentVO {

    @SerializedName("segment_id")
    private int segmentId;

    @SerializedName("title")
    private String title;

    @SerializedName("imageUrl")
    private String imageUrl;

    public int getSegmentId() {
        return segmentId;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
