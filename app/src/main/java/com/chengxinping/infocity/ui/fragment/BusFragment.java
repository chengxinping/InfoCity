package com.chengxinping.infocity.ui.fragment;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.chengxinping.infocity.R;
import com.chengxinping.infocity.bean.BusBean;
import com.chengxinping.infocity.presenter.BusPresenter;
import com.chengxinping.infocity.ui.adapter.BusLineAdapter;
import com.chengxinping.infocity.ui.base.BaseFragment;
import com.chengxinping.infocity.view.IBusView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by 平瓶平瓶子 on 2017/3/15.
 */

public class BusFragment extends BaseFragment<IBusView, BusPresenter> implements IBusView {


    @BindView(R.id.edit_city)
    TextInputEditText mEditCity;
    @BindView(R.id.edit_bus)
    TextInputEditText mEditBus;
    @BindView(R.id.btn_search)
    Button mBtnSearch;
    @BindView(R.id.progress_bar)
    ProgressBar mProgressBar;
    @BindView(R.id.iv_error)
    ImageView mIvError;
    @BindView(R.id.rv_bus)
    RecyclerView mBusLine;

    String mCity, mBus;

    @Override
    protected void initView(View rootView) {
        hideError();
        hideLoading();
        mBusLine.setLayoutManager(new LinearLayoutManager(mContext));
    }

    @Override
    protected int createViewLayoutId() {
        return R.layout.fragment_bus;
    }

    @Override
    protected BusPresenter createPresenter() {
        return new BusPresenter(mContext);
    }

    @Override
    public void showLoading() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void showError() {
        mBusLine.setVisibility(View.GONE);
        mIvError.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideError() {
        mBusLine.setVisibility(View.VISIBLE);
        mIvError.setVisibility(View.GONE);
    }

    @Override
    public void showSnackBar(String message) {
        Snackbar.make(mIvError, message, Snackbar.LENGTH_SHORT)
                .setAction("确定", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                }).show();

    }

    @Override
    public void search() {
        mCity = String.valueOf(mEditCity.getText());
        mBus = String.valueOf(mEditBus.getText());
        if (mCity.equals("")) {
            showSnackBar("请输入城市");
        } else if (mBus.equals("")) {
            showSnackBar("请输入公交线路");
        } else {
            showLoading();
            hideError();
            Date currentTime = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
            String timestamp = formatter.format(currentTime);
            mPresenter.getBus(new Observer<BusBean>() {
                @Override
                public void onSubscribe(Disposable d) {

                }

                @Override
                public void onNext(BusBean value) {
                    if (value.getShowapi_res_body().getRetList().size() == 0) {
                        showError();
                        showSnackBar("城市或公交线路错误！");
                    } else {
                        String temp = value.getShowapi_res_body().getRetList().get(0).getStats() + ";";
                        String[] str = temp.split(";");
                        List<String> mData = new ArrayList<String>();
                        for (String a : str) {
                            mData.add(a);
                        }
                        mBusLine.setAdapter(new BusLineAdapter(mContext, mData));
                    }
                }

                @Override
                public void onError(Throwable e) {
                    showError();
                    showSnackBar("网络错误！");
                }

                @Override
                public void onComplete() {
                    hideLoading();
                }
            }, mCity, mBus, timestamp);
        }

    }

    @OnClick(R.id.btn_search)
    public void onClicked(View v) {
        search();
        //隐藏键盘
        InputMethodManager imm = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }
}
