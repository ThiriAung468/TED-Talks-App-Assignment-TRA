package com.padcmyanmar.ted.talks.assignment.tra.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.padcmyanmar.ted.talks.assignment.tra.R;
import com.padcmyanmar.ted.talks.assignment.tra.adapters.TedTalksAdapter;
import com.padcmyanmar.ted.talks.assignment.tra.data.models.TalksModel;
import com.padcmyanmar.ted.talks.assignment.tra.delegates.TedTalksItemDelegate;

public class MainActivity extends BaseActivity implements TedTalksItemDelegate {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        RecyclerView rvTed = findViewById(R.id.rv_ted_talks);
        TedTalksAdapter tedTalksAdapter = new TedTalksAdapter(this);
        rvTed.setAdapter(tedTalksAdapter);
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
    public void onTapItemView() {
        Intent intent = new Intent(getApplicationContext(),
                TedTalksDetailsActivity.class);
        startActivity(intent);
    }

}
