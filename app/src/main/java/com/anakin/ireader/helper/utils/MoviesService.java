package com.anakin.ireader.helper.utils;

import com.anakin.ireader.model.entity.MovieEntity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 创建者     demo
 * 创建时间   2016/11/22 0022 15:48
 */
public interface MoviesService {
//    http://www.weather.com.cn/data/sk/101010100.html
    @GET("top250")
    Call<MovieEntity> getTopMovie(@Query("start") int start, @Query("count") int count);

}
