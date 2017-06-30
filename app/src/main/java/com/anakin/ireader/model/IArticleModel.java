package com.anakin.ireader.model;

import com.anakin.ireader.presenter.listener.OnArticleListener;

/**
 * 创建者     demo
 * 创建时间   2016/11/25 0025 10:51
 */

public interface IArticleModel {
    void loadArticles(OnArticleListener listener);
}
