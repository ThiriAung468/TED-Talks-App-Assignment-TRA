package com.padcmyanmar.ted.talks.assignment.tra.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.padcmyanmar.ted.talks.assignment.tra.R;
import com.padcmyanmar.ted.talks.assignment.tra.adapters.TedTalksWatchNextAdapter;

public class TedTalksDetailsActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ted_talks_details);

        RecyclerView rvTed = findViewById(R.id.rv_ted_talks_watch_next);
        TedTalksWatchNextAdapter tedTalksWatchNextAdapter = new TedTalksWatchNextAdapter();
        rvTed.setAdapter(tedTalksWatchNextAdapter);
        rvTed.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL,
                false));

    }
}
