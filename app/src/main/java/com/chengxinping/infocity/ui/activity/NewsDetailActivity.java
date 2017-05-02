package com.chengxinping.infocity.ui.activity;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.chengxinping.infocity.R;
import com.chengxinping.infocity.ui.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;


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

    String mImg, mUrl, mType,mTitle;

    @Override

    protected void initView() {
        mType = getIntent().getStringExtra("type");
        mImg = getIntent().getStringExtra("img");
        mUrl = getIntent().getStringExtra("url");
        mTitle = getIntent().getStringExtra("title");
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
        mNewsWeb.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress == 100) {
                    mProgressBar.setVisibility(View.INVISIBLE);
                } else {
                    mProgressBar.setVisibility(View.VISIBLE);
                    mProgressBar.setProgress(newProgress);
                }
            }
        });
        mNewsWeb.loadUrl(mUrl);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_news_detail;
    }

    @OnClick(R.id.fab)
    public void onClick(View v) {
        ShareSDK.initSDK(this);
        OnekeyShare oks = new OnekeyShare();
        oks.disableSSOWhenAuthorize();
        oks.setTitle(mTitle);
        oks.setTitleUrl(mUrl);
        oks.setText(mTitle);
        oks.setSite(getString(R.string.app_name));
        oks.setSiteUrl(mUrl);
        oks.setUrl(mUrl);
        oks.setImageUrl(mImg);
        oks.show(this);
    }
}