package com.anakin.ireader.presenter;

/**
 * 创建者     demo
 * 创建时间   2017/6/26 0026 10:03
 */
public abstract class BasePresenter<T> {
    public T view;

    public void attach(T view) {
        this.view = view;
    }

    public void deatch() {
        this.view = null;
    }
}
