package com.anakin.ireader.model.impl;

import com.anakin.ireader.R;
import com.anakin.ireader.model.ISplashModel;
import com.anakin.ireader.presenter.listener.OnSplashListener;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 创建者     demo
 * 创建时间   2017/6/26 0026 15:58
 */
public class SplashModel implements ISplashModel {

    private static final Integer[] SPLASH_ARRAY = {
            R.drawable.splash0,
            R.drawable.splash1,
            R.drawable.splash2,
            R.drawable.splash3,
            R.drawable.splash4,
            R.drawable.splash5,
            R.drawable.splash6,
            R.drawable.splash7,
            R.drawable.splash8,
            R.drawable.splash9,
            R.drawable.splash10,
            R.drawable.splash11,
            R.drawable.splash12,
            R.drawable.splash13,
            R.drawable.splash14,
            R.drawable.splash15,
            R.drawable.splash16,
    };

    @Override
    public void loadImages(final OnSplashListener listener) {

        final List<Integer> images = new ArrayList<>();
        Observable.from(SPLASH_ARRAY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onCompleted() {
                        listener.onSuccess(images);
                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.onFail();
                    }

                    @Override
                    public void onNext(Integer img) {
                        images.add(img);
                    }
                });
    }
}
