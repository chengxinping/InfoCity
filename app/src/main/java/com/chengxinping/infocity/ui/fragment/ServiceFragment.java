package com.chengxinping.infocity.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.chengxinping.infocity.R;
import com.chengxinping.infocity.api.ApiFactory;
import com.chengxinping.infocity.api.ServiceApi;
import com.chengxinping.infocity.bean.MessageBean;
import com.chengxinping.infocity.ui.activity.MainActivity;
import com.chengxinping.infocity.ui.adapter.ChatMessageAdapter;
import com.chengxinping.infocity.util.Config;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 平瓶平瓶子 on 2017/3/15.
 */

public class ServiceFragment extends Fragment implements Config {
    @BindView(R.id.lv_message)
    ListView lvMessage;
    @BindView(R.id.iv_send_msg)
    ImageView ivSendMsg;
    @BindView(R.id.et_msg)
    EditText etMsg;

    private List<MessageBean> msgList = new ArrayList<>();
    private ChatMessageAdapter msgAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_service, null);
        ButterKnife.bind(this, view);
        ((MainActivity) getActivity()).setFabVisibility(false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
        ((MainActivity) getActivity()).toolbar.setTitle("智能客服");
        initListener();
    }

    private void initListener() {
        ivSendMsg.setOnClickListener(v -> sendMessage());
        lvMessage.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });
    }

    private void initData() {
        if (msgList.size() == 0) {
            MessageBean messageBean = new MessageBean(MessageBean.Type.INCOMING, new Date(), "您好！我是客服小木！\n您有什么要咨询的么？");
            msgList.add(messageBean);
        }
        msgAdapter = new ChatMessageAdapter(this.getContext(), msgList);
        lvMessage.setAdapter(msgAdapter);
        lvMessage.setSelection(msgAdapter.getCount());
    }

    private void sendMessage() {
        String msg = etMsg.getText().toString();
        if (!TextUtils.isEmpty(msg)) {
            MessageBean messageBean = new MessageBean();
            messageBean.setType(MessageBean.Type.OUTCOMING);
            messageBean.setTime(new Date());
            messageBean.setText(msg);
            msgList.add(messageBean);
            msgAdapter.notifyDataSetChanged();
            etMsg.setText("");

            requestApi(msg);
        } else {
            Snackbar.make(ivSendMsg, "发送消息不能为空", Snackbar.LENGTH_SHORT)
                    .setAction("确定", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                        }
                    })
                    .show();
        }
    }

    private void requestApi(String info) {
        ServiceApi api = ApiFactory.getServiceApiSingleton();
        api.getTuringInfo(APIKEY, info)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MessageBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MessageBean value) {
                        handleResponseMessage(value);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void handleResponseMessage(MessageBean value) {
        if (value == null) return;
        value.setTime(new Date());
        value.setType(MessageBean.Type.INCOMING);
        switch (value.getCode()) {
            case 100000:
                value.setText(value.getText());
                break;
            default:
                value.setText(value.getText() + " " + value.getUrl());
        }
        msgList.add(value);
        msgAdapter.notifyDataSetChanged();
    }
}
