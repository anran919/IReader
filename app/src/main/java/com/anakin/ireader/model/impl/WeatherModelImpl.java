package com.anakin.ireader.model.impl;

import android.util.Log;

import com.anakin.ireader.model.WeatherModel;
import com.anakin.ireader.model.entity.Weather;
import com.anakin.ireader.model.entity.WeatherInfo;
import com.anakin.ireader.presenter.OnWeatherListener;
import com.anakin.ireader.utils.HttpMethods;

import rx.Subscriber;

/**
 * 创建者     demo
 * 创建时间   2016/11/22 0022 14:39
 */
public class WeatherModelImpl implements WeatherModel {

    private static final String TAG = "WeatherModelImpl";

    /**
     * 获取view中的数据,presenter中的监听
     *
     * @param cityNo
     * @param weatherListener
     */
    @Override
    public void loadWeather(String cityNo, final OnWeatherListener weatherListener) {
        // 加载数据

        Subscriber<Weather> subscriber = new Subscriber<Weather>() {

            @Override
            public void onCompleted() {
                Log.e(TAG, " onCompleted>>>>>>>");
            }

            @Override
            public void onError(Throwable e) {
                weatherListener.OnError();
                Log.e(TAG, " onError>>>>>>>" + e.toString());
            }

            @Override
            public void onNext(Weather weather) {
                weatherListener.OnSueeess(weather);
                Log.e(TAG, " onNext>>>>>>>" + weather.toString());
            }
        };
        new HttpMethods().getWeatherService(subscriber, cityNo);

    }
}
