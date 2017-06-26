package com.anakin.ireader.presenter.impl;

import com.anakin.ireader.model.MoviesModel;
import com.anakin.ireader.model.entity.MovieEntity;
import com.anakin.ireader.model.impl.MoviesModelImpl;
import com.anakin.ireader.presenter.MoviesPresenter;
import com.anakin.ireader.presenter.OnMoviesListener;
import com.anakin.ireader.ui.view.MoviesView;

/**
 * 创建者     demo
 * 创建时间   2016/11/22 0022 14:41
 */
public class MoviesPresenterImpl implements MoviesPresenter, OnMoviesListener {
    private static final String TAG = "MoviesPresenterImpl";
    MoviesView mMoviesView;
    private final MoviesModel mMoviesModel;

    public MoviesPresenterImpl(MoviesView moviesView) {
        this.mMoviesView = moviesView;  //获取view 实例
        mMoviesModel = new MoviesModelImpl();  // 获取model实例
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
    public void OnError() {
        mMoviesView.hideProgress();
        mMoviesView.showErrorMsg(null);
    }

}
