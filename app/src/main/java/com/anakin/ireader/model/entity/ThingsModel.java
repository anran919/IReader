package com.anakin.ireader.model.entity;

import com.anakin.ireader.presenter.impl.ThingsPresenterImpl;

/**
 * 创建者     demo
 * 创建时间   2016/12/19 0019 15:24
 */
public interface ThingsModel {
    void getThings(ThingsPresenterImpl thingsPresenter); // 数据的加载
}
