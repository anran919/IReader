package com.anakin.ireader.presenter.impl;

import com.anakin.ireader.presenter.IArticlPresenter;
import com.anakin.ireader.presenter.OnAritcleListener;
import com.anakin.ireader.ui.view.IArticleView;

import javax.inject.Inject;

/**
 * 创建者     demo
 * 创建时间   2016/11/25 0025 10:55
 */
public class ArticlPresenter implements IArticlPresenter,OnAritcleListener {


    private  IArticleView mView;

    @Inject
    public ArticlPresenter(IArticleView view) {
        this.mView= view;
    }

    @Override
    public void getArticls() {

    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void onFail() {

    }
}
