package com.anakin.ireader.helper.net;

import com.anakin.ireader.model.entity.ArticleEntity;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * 创建者     demo
 * 创建时间   2016/11/23 0023 16:55
 */
public interface ArticleService {
    @GET("/api/columns/{id}")
    Observable<ArticleEntity> getArticle(@Path("id") String id);
}
