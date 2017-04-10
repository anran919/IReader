package com.anakin.ireader.di.module;

import com.anakin.ireader.ui.view.IArticleView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by demo on 2017/4/10 0010
 */
@Module
public class ArticleModule {
    private IArticleView mView;

    public ArticleModule(IArticleView view) {
        mView = view;
    }

    @Provides
    public IArticleView provideArticleView() {
        return mView;
    }
}
