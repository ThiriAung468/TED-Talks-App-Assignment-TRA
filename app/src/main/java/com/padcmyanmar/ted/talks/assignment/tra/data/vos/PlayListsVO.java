package com.padcmyanmar.ted.talks.assignment.tra.data.vos;

import java.util.List;

public class PlayListsVO {
    private int playListId;
    private String title;
    private String imageUrl;
    private int totalTalks;
    private String description;
    private List<TalksVO> talksInPlayList;

    public int getPlayListId() {
        return playListId;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getTotalTalks() {
        return totalTalks;
    }

    public String getDescription() {
        return description;
    }

    public List<TalksVO> getTalksInPlayList() {
        return talksInPlayList;
    }
}
