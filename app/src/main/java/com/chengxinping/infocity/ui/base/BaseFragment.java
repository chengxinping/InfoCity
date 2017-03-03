package com.chengxinping.infocity.ui.base;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by 平瓶平瓶子 on 2017/3/3.
 */

public abstract class BaseFragment<V, T extends BasePresenter<V>> extends Fragment {
    protected T mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        mPresenter.attachView(((V) this));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(createViewLayoutId(), container, false);
        ButterKnife.bind(this, rootView);
        initView(rootView);

        return rootView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

    protected abstract void initView(View rootView);

    protected abstract int createViewLayoutId();

    protected abstract T createPresenter();
}
