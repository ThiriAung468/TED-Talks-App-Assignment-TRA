package com.padcmyanmar.ted.talks.assignment.tra.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.padcmyanmar.ted.talks.assignment.tra.R;
import com.padcmyanmar.ted.talks.assignment.tra.adapters.TedTalksWatchNextAdapter;
import com.padcmyanmar.ted.talks.assignment.tra.data.models.TalksModel;
import com.padcmyanmar.ted.talks.assignment.tra.data.vos.TalksVO;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TedTalksDetailsActivity extends BaseActivity {

    @BindView(R.id.tv_ted_talks_details)
    TextView tvTedTalksDetails;

    @BindView(R.id.iv_ted_tails_backdrop)
    ImageView ivTedTailsBackDrop;

    @BindView(R.id.tv_people_name_details)
    TextView tvPeopleNameDetails;

    @BindView(R.id.tv_say_topic_details)
    TextView tvSayTopicDetails;

    @BindView(R.id.tv_time_details)
    TextView tvTimeDetails;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ted_talks_details);
        ButterKnife.bind(this,this);

        int talksId = getIntent().getIntExtra("talkId",1);
        Log.d("TalksDetailsActivity", "talksId : " + talksId);

        TalksVO talks = TalksModel.getObjInstance().getTalksById(talksId);
        bindData(talks);

        RecyclerView rvTed = findViewById(R.id.rv_ted_talks_watch_next);
        TedTalksWatchNextAdapter tedTalksWatchNextAdapter = new TedTalksWatchNextAdapter();
        rvTed.setAdapter(tedTalksWatchNextAdapter);
        rvTed.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL,
                false));

    }

    private void bindData(TalksVO talks) {

        tvTedTalksDetails.setText(talks.getDescription());
        Glide.with(ivTedTailsBackDrop.getContext())
                .load(talks.getImageUrl())
                .into(ivTedTailsBackDrop);

        tvPeopleNameDetails.setText(talks.getSpeaker().getName());
        tvSayTopicDetails.setText(talks.getTitle());
        tvTimeDetails.setText(String.valueOf(talks.getDurationInSec()));
    }
}
