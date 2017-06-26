package com.anakin.ireader.base;

import android.view.View;

/**
 * 创建者     demo
 * 创建时间   2017/6/26 0026 10:01
 */
public interface BaseView {

    void showLoading();

    void hideLoading();

    void showError();

    /**
     * 显示loading框
     */
    void showProgress();

    /**
     * 隐藏loading框
     */
    void hideProgress();

    void toast(CharSequence s);

    /**
     * 显示空数据布局
     */
    void showNullLayout();

    /**
     * 隐藏空数据布局
     */
    void hideNullLayout();

    /**
     * 显示异常布局
     * @param listener
     */
    void showErrorLayout(View.OnClickListener listener);

    void hideErrorLayout();


}
