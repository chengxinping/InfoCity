package com.chengxinping.infocity.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.chengxinping.infocity.ui.fragment.NewsListFragment;
import com.chengxinping.infocity.util.Config;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 平瓶平瓶子 on 2017/3/10.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter implements Config {
    private List<String> mTitles;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
        mTitles = new ArrayList<>();
        initTitles(mTitles);
    }

    @Override
    public Fragment getItem(int position) {
        return NewsListFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return mTitles.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }

    private void initTitles(List<String> titles) {
        for (int i = 0; i < ARRYTITLES.length; i++) {
            titles.add(ARRYTITLES[i]);
        }
    }
}
