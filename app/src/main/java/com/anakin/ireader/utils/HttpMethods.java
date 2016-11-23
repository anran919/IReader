package com.anakin.ireader.utils;

import com.anakin.ireader.model.entity.MovieEntity;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;

/**
 * 创建者     demo
 * 创建时间   2016/11/22 0022 16:42
 * 使用单例模式 rx+ retrofit
 */
public class HttpMethods {
    private static final int DEFAULT_TIMEOUT = 5;
    private final String baseUrl = "http://www.weather.com.cn/data/sk/";
    private final MoviesService mService;

    /**
     * 构造方法私有
     */
    public HttpMethods() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();

        mService = retrofit.create(MoviesService.class);
    }


//    //在访问HttpMethods时创建单例
//    private static class SingelInstance{
//        private static final HttpMethods INSTANCE = new HttpMethods();
//    }
//
//    //获取单例
//    public static HttpMethods getInstance(){
//        return SingelInstance.INSTANCE;
//    }


    public void getWeatherService(Subscriber<MovieEntity> subscribe, int start,int count) {
//        mService.getWeatherInfo(start,count)
//                .subscribeOn(Schedulers.io())
//                .unsubscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(subscribe);
    }
}
