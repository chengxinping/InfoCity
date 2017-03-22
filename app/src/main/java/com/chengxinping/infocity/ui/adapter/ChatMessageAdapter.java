package com.chengxinping.infocity.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.chengxinping.infocity.R;
import com.chengxinping.infocity.bean.MessageBean;
import com.github.library.bubbleview.BubbleTextVew;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by 平瓶平瓶子 on 2017/3/22.
 */

public class ChatMessageAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private List<MessageBean> mDatas;

    public ChatMessageAdapter(Context context, List<MessageBean> mDatas) {
        this.mDatas = mDatas;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        MessageBean messageBean = mDatas.get(position);
        if (messageBean.getType() == MessageBean.Type.INCOMING) {
            return 0;
        }
        return 1;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MessageBean messageBean = mDatas.get(position);
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            if (getItemViewType(position) == 0) {
                convertView = mInflater.inflate(R.layout.item_from_msg, parent, false);
                viewHolder.mDate = (TextView) convertView.findViewById(R.id.tv_time);
                viewHolder.mMsg = (BubbleTextVew) convertView.findViewById(R.id.btv_message);
                convertView.setTag(viewHolder);
            } else {
                convertView = mInflater.inflate(R.layout.item_to_message, parent, false);
                viewHolder.mDate = (TextView) convertView.findViewById(R.id.tv_time);
                viewHolder.mMsg = (BubbleTextVew) convertView.findViewById(R.id.btv_message);
                convertView.setTag(viewHolder);
            }
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        if (isDisplayTime(position)) {
            viewHolder.mDate.setVisibility(View.VISIBLE);
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            viewHolder.mDate.setText(df.format(messageBean.getTime()));
        } else {
            viewHolder.mDate.setVisibility(View.GONE);
        }

        viewHolder.mMsg.setText(messageBean.getText());
        return convertView;
    }

    //  一分钟内的请求与回复不显示时间
    public boolean isDisplayTime(int position) {
        if (position > 0) {
            if ((mDatas.get(position).getTime().getTime() - mDatas.get(position - 1).getTime().getTime()) > 60 * 1000) {
                return true;
            } else {
                return false;
            }
        } else if (position == 0) {
            return true;
        } else {
            return false;
        }
    }

    private final class ViewHolder {
        TextView mDate;
        BubbleTextVew mMsg;
    }
}
