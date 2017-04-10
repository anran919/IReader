package com.anakin.ireader.di.component;

import com.anakin.ireader.di.module.ArticleModule;
import com.anakin.ireader.ui.fragment.ArticleFragment;

import dagger.Component;

/**
 * Created by demo on 2017/4/10 0010
 */
@Component(modules = ArticleModule.class)
public interface ArticleComponent {
    void inject(ArticleFragment fragment);
}



