package com.anakin.ireader.di.module;

import com.anakin.ireader.ui.view.IVideoView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by demo on 2017/4/10 0010
 */
@Module
public class VideoModule {

    private  IVideoView mView;

    public VideoModule(IVideoView view) {
        mView = view;
    }

    @Provides
    public IVideoView provideVideoPresenter() {
        return mView;
    }
}
