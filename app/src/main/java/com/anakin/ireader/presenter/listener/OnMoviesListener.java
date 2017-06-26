package com.anakin.ireader.presenter.listener;

import com.anakin.ireader.model.entity.MovieEntity;

/**
 * 创建者     demo
 * 创建时间   2016/11/22 0022 14:47
 */
public interface OnMoviesListener extends BaseOnLoadListener {
    void OnSuccess(MovieEntity entity);
}
