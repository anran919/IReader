package com.anakin.ireader.ui.view;

import com.anakin.ireader.model.entity.Weather;

/**
 * 创建者     demo
 * 创建时间   2016/11/22 0022 14:31
 */
public interface WeatherView  {
    void showLoading();

    void hideLoading();

    void showError();

    void setWeatherInfo(Weather weather);
}
