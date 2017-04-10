package com.anakin.ireader.di.component;

import com.anakin.ireader.di.module.PictureModule;
import com.anakin.ireader.ui.fragment.PictureFragment;

import dagger.Component;

/**
 * Created by demo on 2017/4/10 0010
 */
@Component(modules = PictureModule.class)
public interface PictureComponent {
   void inject(PictureFragment fragment);
}
