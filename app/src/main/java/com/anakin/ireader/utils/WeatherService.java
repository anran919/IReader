package com.anakin.ireader.utils;

import com.anakin.ireader.model.entity.Weather;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * 创建者     demo
 * 创建时间   2016/11/22 0022 15:48
 */
public interface WeatherService {
//    http://www.weather.com.cn/data/sk/101010100.html
    @GET("{cityNo}.html")
    Observable<Weather> getWeatherInfo(@Path("cityNo") String cityNo);

}
