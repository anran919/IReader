package com.anakin.ireader.ui.view;

import com.anakin.ireader.model.entity.ArticleEntity;

import java.util.List;

/**
 * 创建者     demo
 * 创建时间   2016/11/21 0021 18:05
 */
public interface IArticleView  extends BaseView{
    void showArticle(List<ArticleEntity> dailies);
}
