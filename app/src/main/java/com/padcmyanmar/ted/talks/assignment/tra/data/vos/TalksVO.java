package com.padcmyanmar.ted.talks.assignment.tra.data.vos;

import java.util.List;

public class TalksVO {
    private int talkId;
    private String title;
    private SpeakerVO speaker;
    private String imageUrl;
    private String durationInSec;
    private String description;
    private List<TagVO> tag;

    public int getTalkId() {
        return talkId;
    }

    public String getTitle() {
        return title;
    }

    public SpeakerVO getSpeaker() {
        return speaker;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getDurationInSec() {
        return durationInSec;
    }

    public String getDescription() {
        return description;
    }

    public List<TagVO> getTag() {
        return tag;
    }
}
