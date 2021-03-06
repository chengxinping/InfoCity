package com.chengxinping.infocity.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chengxinping.infocity.R;
import com.chengxinping.infocity.bean.NewsBean;
import com.chengxinping.infocity.ui.activity.MainActivity;
import com.chengxinping.infocity.ui.activity.NewsDetailActivity;

import java.util.List;

/**
 * Created by 平瓶平瓶子 on 2017/3/6.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    private Context mContext;
    private List<NewsBean.ResultBean.DataBean> mData;

    public NewsAdapter(Context context, NewsBean news) {
        mContext = context;
        mData = news.getResult().getData();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_news, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTitle.setText(mData.get(position).getTitle());
        holder.mDate.setText(mData.get(position).getDate());
        Glide.with(mContext).load(mData.get(position).getThumbnail_pic_s()).into(holder.mImg);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(((MainActivity) mContext), NewsDetailActivity.class);
                intent.putExtra("img", mData.get(position).getThumbnail_pic_s());
                intent.putExtra("url", mData.get(position).getUrl());
                intent.putExtra("title",mData.get(position).getTitle());
                intent.putExtra("type",mData.get(position).getCategory());
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(((MainActivity) mContext), holder.mImg, "transition_animation_news_photos");
                ((MainActivity) mContext).startActivity(intent,options.toBundle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTitle;
        TextView mDate;
        ImageView mImg;

        public ViewHolder(View itemView) {
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.item_news_title_tv);
            mDate = (TextView) itemView.findViewById(R.id.item_news_date_tv);
            mImg = (ImageView) itemView.findViewById(R.id.item_news_img);
        }
    }
}
