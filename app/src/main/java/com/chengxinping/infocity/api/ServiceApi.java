package com.chengxinping.infocity.api;

import com.chengxinping.infocity.bean.MessageBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by 平瓶平瓶子 on 2017/3/22.
 */

public interface ServiceApi {
    @GET("api")
    Observable<MessageBean> getTuringInfo(@Query("key") String key, @Query("info") String info);
}
