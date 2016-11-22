package com.anakin.ireader.model;

import com.anakin.ireader.presenter.OnWeatherListener;

/**
 * 创建者     demo
 * 创建时间   2016/11/22 0022 14:39
 */
public interface WeatherModel {

   void loadWeather(String cityNo, OnWeatherListener weatherListener);
}
