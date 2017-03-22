package com.chengxinping.infocity.ui.base;

import com.chengxinping.infocity.api.ApiFactory;
import com.chengxinping.infocity.api.NewsApi;
import com.chengxinping.infocity.api.ToolsApi;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Created by 平瓶平瓶子 on 2017/3/3.
 */

public abstract class BasePresenter<V> {
    protected Reference<V> mViewRef;

    public static final NewsApi newsApi = ApiFactory.getNewsApiSingleton();
    public static final ToolsApi toolsApi = ApiFactory.getToolsApiSingleton();

    public void attachView(V view) {
        mViewRef = new WeakReference<V>(view);
    }

    protected V getView() {
        return mViewRef.get();
    }

    public boolean isViewAttached() {
        return mViewRef != null && mViewRef.get() != null;
    }

    public void detachView() {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
    }
}
