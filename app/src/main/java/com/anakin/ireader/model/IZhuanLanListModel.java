package com.anakin.ireader.model;

import com.anakin.ireader.model.entity.ArticleEntity;

/**
 * 创建者     demo
 * 创建时间   2017/7/10 0010 11:47
 */

public interface IZhuanLanListModel {
    void getArticleList(ArticleEntity entity, int page);
}
