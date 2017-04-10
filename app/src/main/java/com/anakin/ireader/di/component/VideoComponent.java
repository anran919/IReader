package com.anakin.ireader.di.component;

import com.anakin.ireader.di.module.VideoModule;
import com.anakin.ireader.ui.fragment.VideoFragment;

import dagger.Component;

/**
 * Created by demo on 2017/4/10 0010
 */
@Component(modules = VideoModule.class)
public interface VideoComponent {
    void inject(VideoFragment fragment);
}



