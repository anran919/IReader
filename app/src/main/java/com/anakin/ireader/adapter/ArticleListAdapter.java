package com.anakin.ireader.adapter;

import android.content.Context;
import android.view.View;

import com.anakin.ireader.adapter.holder.ArticleListHolder;
import com.anakin.ireader.adapter.holder.BaseHolder;

import java.util.List;

/**
 * 创建者     demo
 * 创建时间   2017/7/10 0010 14:04
 */
public class ArticleListAdapter extends BaseAdapter<Object> {
    public ArticleListAdapter(Context context, List<Object> datas, int res_id) {
        super(context, datas, res_id);
    }

    @Override
    public BaseHolder<Object> createHolder(Context context, List<Object> datas, View view) {
        return new ArticleListHolder(context,datas,view);
    }
}
