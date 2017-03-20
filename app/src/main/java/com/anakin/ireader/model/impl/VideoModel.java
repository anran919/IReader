package com.anakin.ireader.model.impl;

import android.util.Log;

import com.anakin.ireader.helper.utils.VideoService;
import com.anakin.ireader.model.IVideoModel;
import com.anakin.ireader.model.entity.VideoEntity;
import com.anakin.ireader.presenter.impl.VideoPresenter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 创建者     demo
 * 创建时间   2016/12/19 0019 15:25
 */
public class VideoModel implements IVideoModel {
    private static final String TAG = "VideoModel";
    private Subscription mSubscription;

    /**
     * 加载数据
     *
     * @param presenter
     */
    @Override
    public void getVideo(final VideoPresenter presenter ) {
        final List<VideoEntity> videos = new ArrayList<>();
        // http://gank.io/api/data/休息视频/10/1
        String baseUrl = "http://gank.io/api/data/休息视频/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        VideoService service = retrofit.create(VideoService.class);
        mSubscription = service.getVideo(10, 10)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<VideoEntity>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, " ===== videos  ==== " + videos.size());
                    }

                    @Override
                    public void onError(Throwable e) {
                        presenter.onFail();
                        Log.d(TAG, " ===== onError ==== " + e.toString());
                    }

                    @Override
                    public void onNext(VideoEntity videoEntity) {
                        List<VideoEntity.ResultsEntity> results = videoEntity.getResults();
                        presenter.onSuccess(results);
                    }
                });
    }


}
