package com.padcmyanmar.ted.talks.assignment.tra.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.padcmyanmar.ted.talks.assignment.tra.R;
import com.padcmyanmar.ted.talks.assignment.tra.adapters.TedTalksAdapter;
import com.padcmyanmar.ted.talks.assignment.tra.data.models.TalksModel;
import com.padcmyanmar.ted.talks.assignment.tra.data.vos.TalksVO;
import com.padcmyanmar.ted.talks.assignment.tra.delegates.TedTalksItemDelegate;
import com.padcmyanmar.ted.talks.assignment.tra.events.SuccessGetTalksEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends BaseActivity implements TedTalksItemDelegate {
    private TedTalksAdapter mTedTalksAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        RecyclerView rvTed = findViewById(R.id.rv_ted_talks);
        mTedTalksAdapter = new TedTalksAdapter(this);
        rvTed.setAdapter(mTedTalksAdapter);
        rvTed.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL,
                false));
        TalksModel.getObjInstance().loadTalksList();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onTapItemView(TalksVO talks) {
        Intent intent = new Intent(getApplicationContext(),
                TedTalksDetailsActivity.class);
        intent.putExtra("talkId", talks.getTalkId() );
        startActivity(intent);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSuccessGetTalks(SuccessGetTalksEvent event){
        Log.d("onSuccessGetTalks","onSuccessGetTalks : "+ event.getTalksList().size());
        mTedTalksAdapter.setTalksList(event.getTalksList());
    }

}
