package com.chengxinping.infocity.api;

/**
 * Created by 平瓶平瓶子 on 2017/3/3.
 */

public class ApiFactory {
    protected static final Object monitor = new Object();
    static NewsApi newsApiSingleton = null;
    static BusApi busApiSingleton = null;
    static ServiceApi serviceApiSingleton = null;

    //单例
    public static NewsApi getNewsApiSingleton() {
        synchronized (monitor) {
            if (newsApiSingleton == null) {
                newsApiSingleton = new ApiRetrofit().getNewsApiService();
            }
            return newsApiSingleton;
        }
    }

    public static BusApi getBusApiSingleton() {
        synchronized (monitor) {
            if (busApiSingleton == null) {
                busApiSingleton = new ApiRetrofit().getBusApiService();
            }
            return busApiSingleton;
        }
    }

    public static ServiceApi getServiceApiSingleton() {
        synchronized (monitor) {
            if (serviceApiSingleton == null) {
                serviceApiSingleton = new ApiRetrofit().getServiceApiService();
            }
        }
        return serviceApiSingleton;
    }
}
