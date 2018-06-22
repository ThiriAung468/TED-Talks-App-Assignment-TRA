package com.padcmyanmar.ted.talks.assignment.tra.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padcmyanmar.ted.talks.assignment.tra.R;
import com.padcmyanmar.ted.talks.assignment.tra.data.vos.TalksVO;
import com.padcmyanmar.ted.talks.assignment.tra.delegates.TedTalksItemDelegate;
import com.padcmyanmar.ted.talks.assignment.tra.viewholders.TedTalksViewHolder;

import java.util.ArrayList;
import java.util.List;

public class TedTalksAdapter extends RecyclerView.Adapter<TedTalksViewHolder> {

    private TedTalksItemDelegate mTedTalksItemDelegate;
    private List<TalksVO> mTalksList;

    public TedTalksAdapter(TedTalksItemDelegate tedTalksItemDelegate) {
        mTedTalksItemDelegate = tedTalksItemDelegate;
        mTalksList = new ArrayList<>();
    }

    @NonNull
    @Override
    public TedTalksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.view_holder_ted_talks, parent, false);
        return new TedTalksViewHolder(view, mTedTalksItemDelegate);
    }

    @Override
    public void onBindViewHolder(@NonNull TedTalksViewHolder holder, int position) {
        holder.setTalksData(mTalksList.get(position));
    }


    @Override
    public int getItemCount() {
        return mTalksList.size();
    }

    public void setTalksList(List<TalksVO> talksList) {
        mTalksList = talksList;
        notifyDataSetChanged();
    }
}
