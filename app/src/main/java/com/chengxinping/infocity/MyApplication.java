package com.chengxinping.infocity;

import android.app.Application;
import android.content.Context;

/**
 * Created by 平瓶平瓶子 on 2017/3/3.
 */

public class MyApplication extends Application {
    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }
}
