package com.anakin.ireader.model.impl;

import android.content.Context;

import com.anakin.ireader.R;
import com.anakin.ireader.helper.net.ArticleService;
import com.anakin.ireader.helper.net.api.ZhuanLanApi;
import com.anakin.ireader.model.IArticleModel;
import com.anakin.ireader.model.entity.ArticleEntity;
import com.anakin.ireader.presenter.listener.OnArticleListener;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;


/**
 * 创建者     demo
 * 创建时间   2016/11/25 0025 10:54
 */
public class ArticleModel implements IArticleModel {

    public static final String TAG = "ArticleModel";
    private Context mContext;
    private ArticleService service;

    public ArticleModel(Context context) {
        this.mContext = context;
    }

    @Override
    public void loadArticles(final OnArticleListener listener) {

        final List<ArticleEntity> articles = new ArrayList<>();
        // people_id
        String[] peoples = mContext.getResources().getStringArray(R.array.people_ids);

        Observable.from(peoples)
                .flatMap(new Func1<String, Observable<String>>() {
                    @Override
                    public Observable<String> call(String s) {
                        return Observable.just(s);
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String people) {
                        if (service == null) {
                            service = getArticleService();
                        } else {
                            service.getArticle(people)
                                    .subscribeOn(Schedulers.io())
                                    .observeOn(AndroidSchedulers.mainThread())
                                    .subscribe(new Subscriber<ArticleEntity>() {
                                        @Override
                                        public void onCompleted() {
                                            listener.onSuccess(articles);
                                        }

                                        @Override
                                        public void onError(Throwable e) {
                                            listener.onFail();
                                        }

                                        @Override
                                        public void onNext(ArticleEntity articleEntity) {
                                            listener.loading();
                                            if (articles != null) {
                                                articles.add(articleEntity);
                                            }

                                        }
                                    });
                        }
                    }
                });
    }

    private ArticleService getArticleService() {
        //TODO 网络请求加载数据
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ZhuanLanApi.ZHUAN_LAN_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit.create(ArticleService.class);
    }


}
