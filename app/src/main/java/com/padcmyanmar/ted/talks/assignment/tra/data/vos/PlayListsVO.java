package com.padcmyanmar.ted.talks.assignment.tra.data.vos;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PlayListsVO {

    @SerializedName("playlist_id")
    private int playListId;

    @SerializedName("title")
    private String title;

    @SerializedName("imageUrl")
    private String imageUrl;

    @SerializedName("totalTalks")
    private int totalTalks;

    @SerializedName("description")
    private String description;

    @SerializedName("talksInPlaylist")
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
