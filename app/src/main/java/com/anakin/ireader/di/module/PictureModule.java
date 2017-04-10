package com.anakin.ireader.di.module;

import com.anakin.ireader.ui.view.IPictureView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by demo on 2017/4/10 0010
 */

@Module
public class PictureModule {
    private IPictureView mView;

    public PictureModule(IPictureView view) {
        mView = view;
    }

    @Provides
    public IPictureView providePicPresenter() {
        return mView;
    }

}
