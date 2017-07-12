package com.anakin.ireader.model.impl;

import android.util.Log;

import com.anakin.ireader.helper.net.ArticlePostListService;
import com.anakin.ireader.helper.net.api.ZhuanLanApi;
import com.anakin.ireader.helper.utils.L;
import com.anakin.ireader.model.IZhuanLanListModel;
import com.anakin.ireader.model.entity.ArticleEntity;
import com.anakin.ireader.model.entity.ArticlePostBean;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 创建者     demo
 * 创建时间   2017/7/10 0010 11:47
 */
public class ZhuanLanListModel implements IZhuanLanListModel {

    private long mTimeOut=5000;

    @Override
    public void getArticleList(ArticleEntity entity, int page) {
        requestPostList(entity, page);
    }

    private void requestPostList(ArticleEntity entity, int page) {
        int offset = page * ZhuanLanApi.DEFAULT_COUNT;
        // 打印请求信息
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                //打印retrofit日志
                Log.i("RetrofitLog","retrofitBack = "+message);
            }
        });
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        //配置okhttp
        OkHttpClient client = new OkHttpClient.Builder()
//                .cache(cache)
                .addInterceptor(loggingInterceptor)
                .connectTimeout(mTimeOut, TimeUnit.SECONDS)
                .readTimeout(mTimeOut, TimeUnit.SECONDS)
                .writeTimeout(mTimeOut, TimeUnit.SECONDS)
                .build();


        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(ZhuanLanApi.ZHUAN_LAN_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        ArticlePostListService service = retrofit.create(ArticlePostListService.class);

        service.getPostList(entity.getSlug(), ZhuanLanApi.DEFAULT_COUNT,offset)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ArticlePostBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        L.d("onError  >>>>> %s",e.toString());
                    }

                    @Override
                    public void onNext(ArticlePostBean bean) {
                        L.d("onNext  >>>>> %s",bean.toString());
                    }
                });

    }
}
