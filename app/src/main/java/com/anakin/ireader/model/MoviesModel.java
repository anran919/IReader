package com.anakin.ireader.model;

import com.anakin.ireader.presenter.OnMoviesListener;

/**
 * 创建者     demo
 * 创建时间   2016/11/22 0022 14:39
 * 加载数据,进行网络请求
 */
public interface MoviesModel {

   void loadMovies(int start,int count, OnMoviesListener weatherListener);
}
