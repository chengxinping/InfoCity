package com.chengxinping.infocity.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.chengxinping.infocity.R;
import com.chengxinping.infocity.bean.NewsBean;
import com.chengxinping.infocity.presenter.NewsListPresenter;
import com.chengxinping.infocity.ui.activity.MainActivity;
import com.chengxinping.infocity.ui.adapter.NewsAdapter;
import com.chengxinping.infocity.ui.base.BaseFragment;
import com.chengxinping.infocity.ui.widget.SpacesItemDecoration;
import com.chengxinping.infocity.util.Config;
import com.chengxinping.infocity.view.INewsListView;

import butterknife.BindView;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class NewsListFragment extends BaseFragment<INewsListView, NewsListPresenter> implements Config, INewsListView {

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
        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getData();
            }
        });
        mSpacingInPixels = getResources().getDimensionPixelSize(R.dimen.item_space);
        mRecyclerView.setHasFixedSize(true);
        ((MainActivity) getActivity()).setFabVisibility(false);
        ((MainActivity) getActivity()).setFabImg(R.drawable.up);
    }

    @Override
    protected int createViewLayoutId() {
        return R.layout.fragment_news_list;
    }

    @Override
    protected NewsListPresenter createPresenter() {
        return new NewsListPresenter(mContext);
    }


    private void setData(NewsBean value) {
        mRefreshLayout.setRefreshing(false);
        mNewsAdapter = new NewsAdapter(mContext, value);
        mRecyclerView.setAdapter(mNewsAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        if (mCount == 0) {
            mRecyclerView.addItemDecoration(new SpacesItemDecoration(mSpacingInPixels));
        }
        mCount++;
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                int lastPosition = -1;
                //当前状态为停止滑动状态SCROLL_STATE_IDLE时
                ((MainActivity) getActivity()).setFabVisibility(true);
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                    lastPosition = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
                    //时判断界面显示的最后item的position是否等于itemCount总数-1也就是最后一个item的position
                    //如果相等则说明已经滑动到最后了
                    if (lastPosition == recyclerView.getLayoutManager().getItemCount() - 1) {
                        Toast.makeText(mContext, "没有更多新闻了", Toast.LENGTH_SHORT).show();
                    }
                }
                scrollToTop();
            }
        });
    }

    @Override
    public void getData() {
        mRefreshLayout.setRefreshing(true);
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

    @Override
    public void scrollToTop() {
        ((MainActivity) getActivity()).setFabOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRecyclerView.smoothScrollToPosition(0);
            }
        });
        if (((LinearLayoutManager) mRecyclerView.getLayoutManager()).findFirstVisibleItemPosition() == 0) {
            ((MainActivity) getActivity()).setFabVisibility(false);
        }
    }
}
