package com.anakin.ireader.model.impl;

import com.anakin.ireader.model.IVideoModel;
import com.anakin.ireader.model.entity.VideoEntity;
import com.anakin.ireader.presenter.impl.VideoPresenter;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * 创建者     demo
 * 创建时间   2016/12/19 0019 15:25
 */
public class VideoModel implements IVideoModel {
    /**
     * 加载数据
     *
     * @param presenter
     */
    @Override
    public void getVideo(final VideoPresenter presenter ) {

        final List<VideoEntity> entitys = new ArrayList<>();

        for (int i=0;i<20;i++){
            VideoEntity entity = new VideoEntity();
            entitys.add(entity);
        }

        Observable.from(entitys)
                .flatMap(new Func1<VideoEntity, Observable<VideoEntity>>() {
                    @Override
                    public Observable<VideoEntity> call(VideoEntity videoEntity) {
                        videoEntity.setVideo_url("http://baobab.wdjcdn.com/14564977406580.mp4");
                        return Observable.just(videoEntity);
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<VideoEntity>() {

                    @Override
                    public void onCompleted() {
                        presenter.onSuccess(entitys);
                    }

                    @Override
                    public void onError(Throwable e) {
                        presenter.onFail();
                    }

                    @Override
                    public void onNext(VideoEntity videoEntity) {

                    }
                });

    }
}
