package com.padcmyanmar.ted.talks.assignment.tra.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.padcmyanmar.ted.talks.assignment.tra.R;
import com.padcmyanmar.ted.talks.assignment.tra.data.vos.TalksVO;
import com.padcmyanmar.ted.talks.assignment.tra.delegates.TedTalksItemDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TedTalksViewHolder extends RecyclerView.ViewHolder {
    private TedTalksItemDelegate mTedTalksItemDelegate;
    private TalksVO mTalks;

    @BindView(R.id.tv_say_topic)
    TextView tvSayTopic;

    @BindView(R.id.tv_time)
    TextView tvTime;

    @BindView(R.id.tv_people_name)
    TextView tvPeopleName;

    @BindView(R.id.iv_ted_talks_img)
    ImageView ivTedTalksImg;

    public TedTalksViewHolder(View itemView, TedTalksItemDelegate tedTalksItemDelegate) {
        super(itemView);

        ButterKnife.bind(this,itemView);

        mTedTalksItemDelegate = tedTalksItemDelegate;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTedTalksItemDelegate.onTapItemView(mTalks);
            }
        });



    }

    public void setTalksData(TalksVO talks){
        mTalks = talks ;
        tvSayTopic.setText(talks.getTitle());
        tvTime.setText(String.valueOf(talks.getDurationInSec()));
        tvPeopleName.setText(talks.getSpeaker().getName());

        Glide.with(ivTedTalksImg.getContext())
                .load(talks.getImageUrl())
                .into(ivTedTalksImg);

    }
}
