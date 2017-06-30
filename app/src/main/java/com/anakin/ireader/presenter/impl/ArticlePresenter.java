package com.anakin.ireader.presenter.impl;

import com.anakin.ireader.model.IArticleModel;
import com.anakin.ireader.model.entity.ArticleEntity;
import com.anakin.ireader.model.impl.ArticleModel;
import com.anakin.ireader.presenter.IArticlePresenter;
import com.anakin.ireader.presenter.listener.OnArticleListener;
import com.anakin.ireader.ui.fragment.ArticleFragment;
import com.anakin.ireader.ui.view.IArticleView;

import java.util.List;

import javax.inject.Inject;

/**
 * 创建者     demo
 * 创建时间   2016/11/25 0025 10:55
 */
public class ArticlePresenter implements IArticlePresenter,OnArticleListener {


    private  IArticleView mView;
    private IArticleModel mModel;
    @Inject
    public ArticlePresenter(IArticleView view) {
        this.mView= view;
        mModel =new ArticleModel(((ArticleFragment)view).getContext());
    }


    @Override
    public void onSuccess(List<ArticleEntity> articles) {
        mView.showArticle(articles);
    }

    @Override
    public void loading() {
        mView.showProgress();
    }

    @Override
    public void onFail() {
        mView.hideProgress();
        mView.showErrorMsg(null);
    }

    @Override
    public void getArticles() {
        mModel.loadArticles(this);
    }
}
