package com.chengxinping.infocity.api;

import com.chengxinping.infocity.MyApplication;
import com.chengxinping.infocity.util.StateUtils;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 平瓶平瓶子 on 2017/3/3.
 */

public class ApiRetrofit {
    public static final String NEWS_BASE_URL = "http://v.juhe.cn/";
    public static final String Bus_BASE_URL = "https://route.showapi.com/";
    public static final String SERVICE_URL = "http://www.tuling123.com/openapi/";

    public NewsApi NewsApiService;
    public BusApi BusApiService;
    public ServiceApi ServiceApiService;

    public ServiceApi getServiceApiService() {
        return ServiceApiService;
    }

    public NewsApi getNewsApiService() {
        return NewsApiService;
    }

    public BusApi getBusApiService() {
        return BusApiService;
    }

    public ApiRetrofit() {
        //缓存
        File httpCacheDirectory = new File(MyApplication.mContext.getCacheDir(), "responses");
        long cacheSize = 10 * 1024 * 1024; //缓存大小 10m
        Cache cache = new Cache(httpCacheDirectory, cacheSize);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(REWRITE_CACHE_CONTROL_INTERCEPTOR)
                .cache(cache)
                .build();
        Retrofit retrofit_news = new Retrofit.Builder()
                .baseUrl(NEWS_BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        NewsApiService = retrofit_news.create(NewsApi.class);
        Retrofit retrofit_bus = new Retrofit.Builder()
                .baseUrl(Bus_BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        BusApiService = retrofit_bus.create(BusApi.class);

        Retrofit retrofit_service = new Retrofit.Builder()
                .baseUrl(SERVICE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ServiceApiService = retrofit_service.create(ServiceApi.class);
    }

    //cache
    Interceptor REWRITE_CACHE_CONTROL_INTERCEPTOR = chain -> {
        CacheControl.Builder cacheBuilder = new CacheControl.Builder();
        cacheBuilder.maxAge(0, TimeUnit.SECONDS);
        cacheBuilder.maxStale(365, TimeUnit.DAYS);
        CacheControl cacheControl = cacheBuilder.build();

        Request request = chain.request();
        //如果没网就用缓存
        if (!StateUtils.isNetworkAvailable(MyApplication.mContext)) {
            request = request.newBuilder()
                    .cacheControl(cacheControl)
                    .build();
        }
        Response originalResponse = chain.proceed(request);
        if (StateUtils.isNetworkAvailable(MyApplication.mContext)) {
            int maxAge = 0; //读取缓存
            return originalResponse.newBuilder()
                    .removeHeader("Pragma")
                    .header("Cache-Control", "public,max-age=" + maxAge)
                    .build();
        } else {
            int maxStale = 60 * 60 * 24 * 28; //4周
            return originalResponse.newBuilder()
                    .removeHeader("Pragma")
                    .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                    .build();
        }
    };
}
