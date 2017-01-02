package com.anakin.ireader.ui.view;

import com.anakin.ireader.model.entity.ThingsEntity;

/**
 * 创建者     demo
 * 创建时间   2016/12/19 0019 15:07
 */
public interface ThingsView {
    void showLoading();
    void hideLoading();
    void showError();
    void setThingsInfo(ThingsEntity entity);
}
