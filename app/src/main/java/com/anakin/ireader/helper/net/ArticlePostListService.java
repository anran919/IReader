package com.anakin.ireader.helper.net;

import com.anakin.ireader.model.entity.ArticlePostBean;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 创建者     demo
 * 创建时间   2016/11/23 0023 16:55
 */
public interface ArticlePostListService {
    String KEY_LIMIT = "limit";
    String KEY_OFFSET = "offset";

    @GET("/api/columns/{id}/posts")
    Observable<ArticlePostBean> getPostList(@Path("id") String id, @Query(KEY_LIMIT) int limit, @Query(KEY_OFFSET) int offset);
}
