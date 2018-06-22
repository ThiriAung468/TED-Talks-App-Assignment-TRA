package com.padcmyanmar.ted.talks.assignment.tra.events;

import com.padcmyanmar.ted.talks.assignment.tra.data.vos.TalksVO;

import java.util.List;

public class SuccessGetTalksEvent {

    private List<TalksVO> talksList;

    public SuccessGetTalksEvent(List<TalksVO> talksList) {
        this.talksList = talksList;
    }

    public List<TalksVO> getTalksList() {
        return talksList;
    }
}
