package com.anakin.ireader.presenter.impl;

import com.anakin.ireader.model.IZhuanLanListModel;
import com.anakin.ireader.model.entity.ArticleEntity;
import com.anakin.ireader.model.impl.ZhuanLanListModel;
import com.anakin.ireader.presenter.IZhuanLanListPresenter;
import com.anakin.ireader.presenter.listener.OnArticleListListener;

/**
 * 创建者     demo
 * 创建时间   2017/7/10 0010 11:27
 */
public class ZhuanLanListPresenter extends IZhuanLanListPresenter implements OnArticleListListener {


    private IZhuanLanListModel mModel;

    @Override
    public void requestPostList(ArticleEntity entity, int page) {
        mModel = new ZhuanLanListModel();
        mModel.getArticleList(entity,page);
    }

    @Override
    public void onFail() {

    }

    @Override
    public void OnSuccess(Object obj) {

    }


}
