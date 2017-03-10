package com.chengxinping.infocity.api;

import com.chengxinping.infocity.bean.NewsBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by 平瓶平瓶子 on 2017/3/3.
 */

public interface NewsApi {
    @GET("toutiao/index?")
    Observable<NewsBean> getNews(@QueryMap Map<String, String> map);
}
