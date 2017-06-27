package com.anakin.ireader.helper.net;

import com.anakin.ireader.model.entity.VideoEntity;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by demo on 2017/3/14 0014
 */
public interface VideoService {
    @GET("{count}/{page}")
    Observable<VideoEntity> getVideo(@Path("count") int count, @Path("page") int  page);

}
