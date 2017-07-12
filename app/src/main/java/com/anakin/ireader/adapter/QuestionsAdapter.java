package com.anakin.ireader.adapter;

import android.content.Context;
import android.view.View;

import com.anakin.ireader.adapter.holder.BaseHolder;

import java.util.List;

/**
 * 创建者     demo
 * 创建时间   2016/11/21 0021 14:37
 */
public class QuestionsAdapter extends BaseAdapter<String> {

    public QuestionsAdapter(Context context,List<String> datas, int res_id) {
        super(context,datas, res_id);
    }

    @Override
    public BaseHolder<String> createHolder(Context context, List<String> datas, View view) {
        return null;
    }
}
