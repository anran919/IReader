package com.anakin.ireader.model.impl;

import com.anakin.ireader.model.IMoviesModel;
import com.anakin.ireader.model.entity.MovieEntity;
import com.anakin.ireader.presenter.listener.OnMoviesListener;
import com.anakin.ireader.helper.utils.MoviesService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 创建者     demo
 * 创建时间   2016/11/22 0022 14:39
 */
public class MoviesModel implements IMoviesModel {

    private static final String TAG = "MoviesModel";

    /**
     * 获取view中的数据,presenter中的监听
     *
     * @param start
     * @param count
     * @param moviesListener
     */
    @Override
    public void loadMovies(int start, int count, final OnMoviesListener moviesListener) {
        // 加载数据
//        String baseUrl = "https://api.douban.com/v2/movie/top250/1/10";
        String baseUrl = "https://api.douban.com/v2/movie/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MoviesService service = retrofit.create(MoviesService.class);
        Call<MovieEntity> call = service.getTopMovie(start,count);
        call.enqueue(new Callback<MovieEntity>() {
            @Override
            public void onResponse(Call<MovieEntity> call, Response<MovieEntity> response) {
//                resultTV.setText(response.body().toString());
                MovieEntity MovieEntity = response.body();
                moviesListener.OnSuccess(MovieEntity);

            }

            @Override
            public void onFailure(Call<MovieEntity> call, Throwable t) {
                moviesListener.onFail();
//                resultTV.setText(t.getMessage());
            }
        });

//        Subscriber<MovieEntity> subscriber = new Subscriber<MovieEntity>() {
//
//            @Override
//            public void onCompleted() {
//                Log.e(TAG, " onCompleted>>>>>>>");
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                weatherListener.OnError();
//                Log.e(TAG, " onError>>>>>>>" + e.toString());
//            }
//
//            @Override
//            public void onNext(MovieEntity MovieEntity) {
//                weatherListener.OnSueeess(MovieEntity);
//                Log.e(TAG, " onNext>>>>>>>" + MovieEntity.toString());
//            }
//        };
//        new HttpMethods().getWeatherService(subscriber, cityNo);
    }
}
