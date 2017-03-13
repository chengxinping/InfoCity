package com.chengxinping.infocity.ui.activity;

import android.graphics.Bitmap;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.chengxinping.infocity.R;
import com.chengxinping.infocity.ui.base.BaseActivity;

import butterknife.BindView;


public class NewsDetailActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.toolbar_layout)
    CollapsingToolbarLayout mToolBarLayout;
    @BindView(R.id.news_detail_photo_iv)
    ImageView mNewsImg;
    @BindView(R.id.news_web)
    WebView mNewsWeb;
    @BindView(R.id.progress_bar)
    ProgressBar mProgressBar;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    String mImg, mUrl, mType;

    @Override

    protected void initView() {
        mType = getIntent().getStringExtra("type");
        mImg = getIntent().getStringExtra("img");
        mUrl = getIntent().getStringExtra("url");
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolBarLayout.setTitle(mType);
        mToolBarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.white));//设置扩展时title文字颜色
        mToolBarLayout.setCollapsedTitleTextColor(getResources().getColor(android.R.color.white));
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        Glide.with(this).load(mImg).into(mNewsImg);
        WebSettings webSettings = mNewsWeb.getSettings();
        //设置WebView属性，能够执行Javascript脚本
        webSettings.setJavaScriptEnabled(true);
        //设置可以访问文件
        webSettings.setAllowFileAccess(true);
        mNewsWeb.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                mProgressBar.setVisibility(View.GONE);
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                mProgressBar.setVisibility(View.VISIBLE);
            }
        });
        mNewsWeb.loadUrl(mUrl);
    }
    
    @Override
    protected int getContentViewId() {
        return R.layout.activity_news_detail;
    }
}
