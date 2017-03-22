package com.chengxinping.infocity.presenter;

import com.chengxinping.infocity.bean.IDCardBean;
import com.chengxinping.infocity.bean.MailBean;
import com.chengxinping.infocity.bean.OilBean;
import com.chengxinping.infocity.bean.PM25Bean;
import com.chengxinping.infocity.ui.base.BasePresenter;
import com.chengxinping.infocity.util.Config;
import com.chengxinping.infocity.view.IToolsView;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 平瓶平瓶子 on 2017/3/19.
 */

public class ToolsPresenter extends BasePresenter<IToolsView> implements Config {

    public void getPM25(Observer<PM25Bean> observer, String city, String timestamp) {
        toolsApi.getPM25(city, SHOW_APPID, SHOW_SIGN, timestamp)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public void getOil(Observer<OilBean> observer, String prov, String timestamp) {
        toolsApi.getOil(prov, SHOW_APPID, SHOW_SIGN, timestamp)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public void getMail(Observer<MailBean> observer, String nu, String timestamp) {
        toolsApi.getMail(nu, SHOW_APPID, SHOW_SIGN, timestamp)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public void getIDCard(Observer<IDCardBean> observer, String id, String timestamp) {
        toolsApi.getIDCard(id, SHOW_APPID, SHOW_SIGN, timestamp)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
