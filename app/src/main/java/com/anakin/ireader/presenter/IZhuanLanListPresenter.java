package com.anakin.ireader.presenter;

import com.anakin.ireader.model.entity.ArticleEntity;
import com.anakin.ireader.ui.view.IZhuanLanListView;

/**
 * 创建者     demo
 * 创建时间   2017/7/10 0010 11:27
 */

public abstract class IZhuanLanListPresenter extends BasePresenter<IZhuanLanListView> {

    public abstract void requestPostList(ArticleEntity entity, int page);
}
