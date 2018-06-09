package com.padcmyanmar.ted.talks.assignment.tra.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padcmyanmar.ted.talks.assignment.tra.R;
import com.padcmyanmar.ted.talks.assignment.tra.delegates.TedTalksItemDelegate;
import com.padcmyanmar.ted.talks.assignment.tra.viewholders.TedViewHolder;

import java.util.Objects;

public class TedAdapter extends RecyclerView.Adapter {

    private TedTalksItemDelegate mTedTalksItemDelegate;
    public TedAdapter(TedTalksItemDelegate tedTalksItemDelegate){
        mTedTalksItemDelegate =  tedTalksItemDelegate;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater =  LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.view_holder_ted_talks,parent,false);
        return new TedViewHolder(view,mTedTalksItemDelegate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 15;
    }
}
