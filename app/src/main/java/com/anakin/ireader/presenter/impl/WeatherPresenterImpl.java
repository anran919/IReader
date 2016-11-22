package com.anakin.ireader.presenter.impl;

import com.anakin.ireader.model.WeatherModel;
import com.anakin.ireader.model.entity.Weather;
import com.anakin.ireader.model.impl.WeatherModelImpl;
import com.anakin.ireader.presenter.OnWeatherListener;
import com.anakin.ireader.presenter.WeatherPresenter;
import com.anakin.ireader.ui.view.WeatherView;

/**
 * 创建者     demo
 * 创建时间   2016/11/22 0022 14:41
 */
public class WeatherPresenterImpl implements WeatherPresenter, OnWeatherListener {

    WeatherView mWeatherView;
    private final WeatherModel mWeatherModel;

    public WeatherPresenterImpl(WeatherView weatherView) {
        this.mWeatherView = weatherView;  //获取view 实例
        mWeatherModel = new WeatherModelImpl();  // 获取model实例
    }

    @Override
    public void getWeather(String cityNo) {
        mWeatherView.showLoading();  // 调用view 的方法
        mWeatherModel.loadWeather(cityNo, this); //
    }

    @Override
    public void OnSueeess(Weather weather) {
        mWeatherView.hideLoading(); // 隐藏京进度条
        mWeatherView.setWeatherInfo(weather); // 传递结果到view
    }

    @Override
    public void OnError() {
        mWeatherView.hideLoading();
        mWeatherView.showError();

    }
}
