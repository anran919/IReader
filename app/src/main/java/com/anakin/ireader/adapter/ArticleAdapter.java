package com.anakin.ireader.adapter;

import android.content.Context;
import android.view.View;

import com.anakin.ireader.adapter.holder.ArticleHolder;
import com.anakin.ireader.adapter.holder.BaseHolder;
import com.anakin.ireader.model.entity.ArticleEntity;

import java.util.List;

/**
 * 创建者     demo
 * 创建时间   2016/11/21 0021 14:37
 */
public class ArticleAdapter extends BaseAdapter<ArticleEntity> {
    public ArticleAdapter(Context context, List<ArticleEntity> datas, int res_id) {
        super(context,datas, res_id);
    }

    @Override
    public BaseHolder<ArticleEntity> createHolder(Context context, List<ArticleEntity> datas, View view) {
        return new ArticleHolder(context,datas,view);
    }



}
