package com.anakin.ireader.model.impl;

import android.util.Log;

import com.anakin.ireader.model.PictureModel;
import com.anakin.ireader.model.entity.PictureEntity;
import com.anakin.ireader.presenter.OnPictureListener;
import com.anakin.ireader.helper.utils.PictureService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 创建者     demo
 * 创建时间   2016/11/23 0023 15:23
 */
public class PictureModelImpl implements PictureModel {

    private static final String TAG ="PictureModelImpl" ;

    //    http://gank.io/api/data/福利/10/1
    @Override
    public void loadPicture(int count, int page, final OnPictureListener pictureListener) {
        String baseUrl = "http://gank.io/api/data/福利/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PictureService service = retrofit.create(PictureService.class);

        Call<PictureEntity> call = service.getPictures(count, page);
        call.enqueue(new Callback<PictureEntity>() {
            @Override
            public void onResponse(Call<PictureEntity> call, Response<PictureEntity> response) {
                Log.e(TAG,"response ---------------->"+response);
                PictureEntity entity = response.body();
                List<PictureEntity.ResultsEntity> results = entity.getResults();
                pictureListener.onSuccess(results);
            }

            @Override
            public void onFailure(Call<PictureEntity> call, Throwable throwable) {
                Log.e(TAG,"throwable ---------------->"+throwable);
                pictureListener.onFail();
            }
        });


    }
}
