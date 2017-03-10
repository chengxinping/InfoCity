package com.chengxinping.infocity.presenter;

import android.content.Context;

import com.chengxinping.infocity.bean.NewsBean;
import com.chengxinping.infocity.ui.base.BasePresenter;
import com.chengxinping.infocity.util.Config;
import com.chengxinping.infocity.view.INewsListView;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by 平瓶平瓶子 on 2017/3/4.
 */

public class NewsListPresenter extends BasePresenter<INewsListView> implements Config {
    private Context context;

    public NewsListPresenter(Context context) {
        this.context = context;
    }

    public void getNews(Observer<NewsBean> observer,int type) {
        newsApi.getNews(getParams(type
        ))
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    private Map<String, String> getParams(int type) {
        Map<String, String> map = new HashMap<>();
        map.put("type", ARRYTYPE[type]);
        map.put("key", KEY_JUHE);
        return map;
    }
}
