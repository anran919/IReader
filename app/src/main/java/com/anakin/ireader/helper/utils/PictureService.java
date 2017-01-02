package com.anakin.ireader.helper.utils;

import com.anakin.ireader.model.entity.PictureEntity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * 创建者     demo
 * 创建时间   2016/11/23 0023 16:55
 */
public interface PictureService {
    @GET("{count}/{page}")
    Call<PictureEntity> getPictures(@Path("count") int count, @Path("page") int page);
}
