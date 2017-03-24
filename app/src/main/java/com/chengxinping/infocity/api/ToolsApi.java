package com.chengxinping.infocity.api;

import com.chengxinping.infocity.bean.BusBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by 平瓶平瓶子 on 2017/3/13.
 */

public interface ToolsApi {
    //pm2.5
    @GET("844-2")
    Observable<BusBean> getBus(@Query("busNo") String bus, @Query("city") String city, @Query("showapi_appid") String showapi_appid, @Query("showapi_sign") String showapi_sign, @Query("showapi_timestamp") String showapi_timestamp);

}
