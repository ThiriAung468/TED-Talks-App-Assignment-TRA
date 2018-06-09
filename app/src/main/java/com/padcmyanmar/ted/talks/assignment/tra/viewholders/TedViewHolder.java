package com.padcmyanmar.ted.talks.assignment.tra.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.padcmyanmar.ted.talks.assignment.tra.R;
import com.padcmyanmar.ted.talks.assignment.tra.delegates.TedTalksItemDelegate;

public class TedViewHolder extends RecyclerView.ViewHolder {
    private TedTalksItemDelegate mTedTalksItemDelegate;
    public TedViewHolder(View itemView,TedTalksItemDelegate tedTalksItemDelegate) {
        super(itemView);
        mTedTalksItemDelegate = tedTalksItemDelegate;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTedTalksItemDelegate.onTapImage();
            }
        });



    }


}
