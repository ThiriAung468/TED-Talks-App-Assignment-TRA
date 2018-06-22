package com.padcmyanmar.ted.talks.assignment.tra.data.models;

import com.padcmyanmar.ted.talks.assignment.tra.data.vos.TalksVO;
import com.padcmyanmar.ted.talks.assignment.tra.events.SuccessGetTalksEvent;
import com.padcmyanmar.ted.talks.assignment.tra.network.HttpUrlConnectionDataAgentImpl;
import com.padcmyanmar.ted.talks.assignment.tra.network.OkHttpDataAgentImpl;
import com.padcmyanmar.ted.talks.assignment.tra.network.RetrofitDataAgentImpl;
import com.padcmyanmar.ted.talks.assignment.tra.network.TalksDataAgent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;
import java.util.Map;

public class TalksModel {
    private static final String DUMMY_ACCESS_TOKEN = "b002c7e1a528b7cb460933fc2875e916";
    private static TalksModel objInstance;
    private TalksDataAgent mDataAgent;

    private Map<Integer, TalksVO> mTalksMap;

    private TalksModel() {

        //mDataAgent = HttpUrlConnectionDataAgentImpl.getObjInstance();
       // mDataAgent = OkHttpDataAgentImpl.getInstance();
        mDataAgent = RetrofitDataAgentImpl.getInstance();

        mTalksMap = new HashMap<>();
        EventBus.getDefault().register(this);
    }
    public static TalksModel getObjInstance(){
        if(objInstance == null){
            objInstance = new TalksModel();
        }
        return objInstance;
    }

    public void loadTalksList(){
     mDataAgent.loadTalksList(1,DUMMY_ACCESS_TOKEN);
    }

    public TalksVO getTalksById(int talksId){
        return mTalksMap.get(talksId);
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onSuccessGetTalks(SuccessGetTalksEvent event){
        for(TalksVO talks : event.getTalksList()){
            mTalksMap.put(talks.getTalkId(), talks);
        }
    }
}
