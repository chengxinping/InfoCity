package com.chengxinping.infocity.presenter;

import android.content.Context;

import com.chengxinping.infocity.bean.BusBean;
import com.chengxinping.infocity.ui.base.BasePresenter;
import com.chengxinping.infocity.util.Config;
import com.chengxinping.infocity.view.IBusView;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 平瓶平瓶子 on 2017/3/19.
 */

public class BusPresenter extends BasePresenter<IBusView> implements Config {
    private Context context;

    public BusPresenter(Context context) {
        this.context = context;
    }

    public void getBus(Observer<BusBean> observer, String city, String bus, String timestamp) {
        busApi.getBus(bus, city, SHOW_APPID, SHOW_SIGN, timestamp)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

}
