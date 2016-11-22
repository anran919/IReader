package com.anakin.ireader.presenter;

import com.anakin.ireader.model.entity.Weather;

/**
 * 创建者     demo
 * 创建时间   2016/11/22 0022 14:47
 */
public interface OnWeatherListener {

    void OnSueeess(Weather weather);

    void OnError();
}
