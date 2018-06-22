package com.padcmyanmar.ted.talks.assignment.tra.data.vos;

import com.google.gson.annotations.SerializedName;

public class SpeakerVO {

    @SerializedName("speaker_id")
    private int speakerId;

    @SerializedName("name")
    private String name;

    public int getSpeakerId() {
        return speakerId;
    }

    public String getName() {
        return name;
    }
}
