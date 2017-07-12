package com.anakin.ireader.model.impl;

import android.content.Context;

import com.anakin.ireader.R;
import com.anakin.ireader.dao.ZhuanlanDao;
import com.anakin.ireader.helper.net.ArticleService;
import com.anakin.ireader.helper.net.api.ZhuanLanApi;
import com.anakin.ireader.model.IArticleModel;
import com.anakin.ireader.model.entity.ArticleBean;
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
    private ZhuanlanDao mDao;
    private List<ArticleEntity> mArticles;

    public ArticleModel(Context context) {
        this.mContext = context;
    }

    @Override
    public void loadArticles(OnArticleListener listener) {
        mDao = new ZhuanlanDao(mContext);
        mArticles = mDao.getAll();    //先从数据库获取 ,如果失败从网络获取
        if (mArticles.size() == 0) {
            getData(listener);
        }
        listener.onSuccess(mArticles);

    }

    private void getData(final OnArticleListener listener) {
        mArticles = new ArrayList<>();
        // 使用RxJava+Retrofit 数据显示加载不完整的问题
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
                                    .subscribe(new Subscriber<ArticleBean>() {
                                        @Override
                                        public void onCompleted() {

                                        }

                                        @Override
                                        public void onError(Throwable e) {

                                        }

                                        @Override
                                        public void onNext(ArticleBean bean) {
                                            save2DB(bean);
                                        }
                                    });
                        }
                    }
                });
    }

    private void save2DB(ArticleBean bean) {
        ArticleEntity entity = new ArticleEntity();
        entity.setAvatar_id(bean.getAvatar().getId());
        entity.setAvatar_template(bean.getAvatar().getTemplate());
        entity.setDescription(bean.getDescription());
        entity.setName(bean.getName());
        entity.setPostsCount(bean.getPostsCount());
        entity.setSlug(bean.getSlug());
        mArticles.add(entity);
        mDao.add(entity);
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
