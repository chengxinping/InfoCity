package com.chengxinping.infocity.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chengxinping.infocity.R;

import java.util.List;

/**
 * Created by 平瓶平瓶子 on 2017/3/25.
 */

public class BusLineAdapter extends RecyclerView.Adapter<BusLineAdapter.ViewHolder> {
    private Context mContext;
    private List<String> mData;

    public BusLineAdapter(Context context, List<String> data) {
        mContext = context;
        mData = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_bus_line, null));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTvBusLine.setText(mData.get(position).toString());
        holder.mTvBusNumber.setText(position + 1 + "");
        if (position == mData.size() - 1) {
            holder.mLlLine.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTvBusLine;
        LinearLayout mLlLine;
        TextView mTvBusNumber;

        public ViewHolder(View itemView) {
            super(itemView);
            mTvBusLine = (TextView) itemView.findViewById(R.id.tv_bus_line);
            mLlLine = (LinearLayout) itemView.findViewById(R.id.ll_line);
            mTvBusNumber = (TextView) itemView.findViewById(R.id.tv_bus_number);
        }
    }
}
