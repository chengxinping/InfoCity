package com.chengxinping.infocity.ui.fragment;

import android.view.View;

import com.chengxinping.infocity.R;
import com.chengxinping.infocity.presenter.ToolsPresenter;
import com.chengxinping.infocity.ui.base.BaseFragment;
import com.chengxinping.infocity.view.IToolsView;

/**
 * Created by 平瓶平瓶子 on 2017/3/15.
 */

public class ToolsFragment extends BaseFragment<IToolsView, ToolsPresenter> implements IToolsView {
    @Override
    protected void initView(View rootView) {

    }

    @Override
    protected int createViewLayoutId() {
        return R.layout.fragment_tools;
    }

    @Override
    protected ToolsPresenter createPresenter() {
        return new ToolsPresenter(mContext);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
