package com.chengxinping.infocity.api;

import com.chengxinping.infocity.bean.IDCardBean;
import com.chengxinping.infocity.bean.MailBean;
import com.chengxinping.infocity.bean.OilBean;
import com.chengxinping.infocity.bean.PM25Bean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by 平瓶平瓶子 on 2017/3/13.
 */

public interface ToolsApi {
    //pm2.5
    @GET("104-41")
    Observable<PM25Bean> getPM25(@Query("city") String city, @Query("showapi_appid") String showapi_appid, @Query("showapi_sign") String showapi_sign, @Query("showapi_timestamp") String showapi_timestamp);

    //今日油价
    @GET("138-46")
    Observable<OilBean> getOil(@Query("prov") String prov, @Query("showapi_appid") String showapi_appid, @Query("showapi_sign") String showapi_sign, @Query("showapi_timestamp") String showapi_timestamp);

    //快递单号查询
    @GET("880-1")
    Observable<MailBean> getMail(@Query("nu") String nu, @Query("showapi_appid") String showapi_appid, @Query("showapi_sign") String showapi_sign, @Query("showapi_timestamp") String showapi_timestamp);

    //身份证查询
    @GET("25-3")
    Observable<IDCardBean> getIDCard(@Query("id") String id, @Query("showapi_appid") String showapi_appid, @Query("showapi_sign") String showapi_sign, @Query("showapi_timestamp") String showapi_timestamp);

}
