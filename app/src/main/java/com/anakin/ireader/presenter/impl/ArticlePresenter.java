package com.anakin.ireader.presenter.impl;


import com.anakin.ireader.presenter.ListPresenter;
import com.anakin.ireader.ui.view.ArticleView;

/**
 * 创建者     demo
 * 创建时间   2016/11/21 0021 18:15
 */
public class ArticlePresenter implements ListPresenter {

    private  static  final ArticlePresenter ARTICLE_PRESENTER =new ArticlePresenter();
    private ArticlePresenter(){}
    @Override
    public void loadListDates() {

    }

    @Override
    public void loadMore() {

    }

    @Override
    public void attachView(ArticleView view) {

    }

    @Override
    public void detach() {

    }

    @Override
    public void onResume() {

    }

    public static ArticlePresenter getInstance() {
        return ARTICLE_PRESENTER;
    }
}
