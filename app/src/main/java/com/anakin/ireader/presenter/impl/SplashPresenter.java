package com.anakin.ireader.presenter.impl;

import com.anakin.ireader.model.ISplashModel;
import com.anakin.ireader.model.impl.SplashModel;
import com.anakin.ireader.presenter.ISplashPresenter;
import com.anakin.ireader.presenter.listener.OnSplashListener;

import java.util.List;

/**
 * 创建者     demo
 * 创建时间   2017/6/26 0026 15:52
 */
public class SplashPresenter extends ISplashPresenter implements OnSplashListener {
    private ISplashModel mModel;

    @Override
    public void getImage() {
        mModel = new SplashModel();
        mModel.loadImages(this);
    }

    @Override
    public void onSuccess(List<Integer> results) {
        view.setSplashView(results);
    }

    @Override
    public void onFail() {

    }
}
