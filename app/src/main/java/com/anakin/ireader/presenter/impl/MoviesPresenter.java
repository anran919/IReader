package com.anakin.ireader.presenter.impl;

import com.anakin.ireader.model.IMoviesModel;
import com.anakin.ireader.model.entity.MovieEntity;
import com.anakin.ireader.model.impl.MoviesModel;
import com.anakin.ireader.presenter.IMoviesPresenter;
import com.anakin.ireader.presenter.listener.OnMoviesListener;
import com.anakin.ireader.ui.view.MoviesView;

/**
 * 创建者     demo
 * 创建时间   2016/11/22 0022 14:41
 */
public class MoviesPresenter implements IMoviesPresenter, OnMoviesListener {
    private static final String TAG = "MoviesPresenter";
    MoviesView mMoviesView;
    private final IMoviesModel mMoviesModel;

    public MoviesPresenter(MoviesView moviesView) {
        this.mMoviesView = moviesView;  //获取view 实例
        mMoviesModel = new MoviesModel();  // 获取model实例
    }

    @Override
    public void getMovies(int start, int count) {
        mMoviesView.showProgress();  // 调用view 的方法
        mMoviesModel.loadMovies(start, count, this); //
    }

    @Override
    public void OnSuccess(MovieEntity movieEntity) {
        mMoviesView.hideProgress(); // 隐藏进度条
        mMoviesView.setMoviesInfo(movieEntity); // 传递结果到view
    }


    @Override
    public void onFail() {
        mMoviesView.hideProgress();
        mMoviesView.showErrorMsg(null);
    }
}
