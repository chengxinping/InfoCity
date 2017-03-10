package com.chengxinping.infocity.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chengxinping.infocity.R;
import com.chengxinping.infocity.bean.NewsBean;
import com.chengxinping.infocity.presenter.NewsListPresenter;
import com.chengxinping.infocity.ui.adapter.NewsAdapter;
import com.chengxinping.infocity.ui.base.BaseFragment;
import com.chengxinping.infocity.ui.widget.SpacesItemDecoration;
import com.chengxinping.infocity.util.Config;
import com.chengxinping.infocity.view.INewsListView;

import butterknife.BindView;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class NewsListFragment extends BaseFragment<INewsListView, NewsListPresenter> implements Config {

    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout mRefreshLayout;
    @BindView(R.id.news_recycler_view)
    RecyclerView mRecyclerView;

    private int mType;
    private NewsAdapter mNewsAdapter;
    private int mSpacingInPixels;
    private int mCount = 0;

    public static NewsListFragment newInstance(int postion) {
        NewsListFragment fragment = new NewsListFragment();
        Bundle args = new Bundle();
        args.putInt(KEY_POSTION, postion);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mType = getArguments().getInt(KEY_POSTION);
        }
    }

    @Override
    protected void initView(View rootView) {
        mRefreshLayout.setColorSchemeResources(R.color.tab_indicator, R.color.tab_select_text_color, R.color.refresh_color, R.color.colorAccent);
        getData();
    }

    @Override
    protected int createViewLayoutId() {
        return R.layout.fragment_news_list;
    }

    @Override
    protected NewsListPresenter createPresenter() {
        return new NewsListPresenter(mContext);
    }

    public void getData() {
        Observer<NewsBean> observer = new Observer<NewsBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(NewsBean value) {
                setData(value);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
        mPresenter.getNews(observer, mType);
    }

    private void setData(NewsBean value) {
        mNewsAdapter = new NewsAdapter(mContext, value);
        mRecyclerView.setAdapter(mNewsAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mSpacingInPixels = getResources().getDimensionPixelSize(R.dimen.item_space);
        mRecyclerView.setHasFixedSize(true);
        if (mCount == 0) {
            mRecyclerView.addItemDecoration(new SpacesItemDecoration(mSpacingInPixels));
        }
        mCount++;
    }
}
