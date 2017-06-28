package com.anakin.ireader.model.impl;

import android.util.Log;

import com.anakin.ireader.helper.net.ArticleService;
import com.anakin.ireader.helper.net.api.ZhuanLanApi;
import com.anakin.ireader.helper.utils.L;
import com.anakin.ireader.model.IArticleModel;
import com.anakin.ireader.model.entity.ArticleEntity;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * 创建者     demo
 * 创建时间   2016/11/25 0025 10:54
 */
public class ArticleModel implements IArticleModel {

    public static final String TAG = "ArticleModel";
    @Override
    public void loadArticles(Object object) {
        //TODO 网络请求加载数据
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ZhuanLanApi.ZHUAN_LAN_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        ArticleService service = retrofit.create(ArticleService.class);
        service.getArticle("limiao")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ArticleEntity>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        L.d(" Throwable : : ",e.toString());
                    }

                    @Override
                    public void onNext(ArticleEntity articleEntity) {
                        Log.d(TAG,"articleEntity  :::>>> "+articleEntity);
                    }
                });
    }
}
