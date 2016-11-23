package com.anakin.ireader.adapter;

import android.content.Context;
import android.view.View;

import com.anakin.ireader.adapter.holder.BaseHolder;
import com.anakin.ireader.adapter.holder.MovicesHolder;
import com.anakin.ireader.model.entity.MovieEntity;

import java.util.List;

/**
 * 创建者     demo
 * 创建时间   2016/11/21 0021 14:39
 */
public class MovicesAdapter extends BaseAdapter<MovieEntity.SubjectsEntity> {
    public MovicesAdapter(Context context, List<MovieEntity.SubjectsEntity> datas, int res_id) {
       super(context,datas,res_id);
    }

    @Override
    public BaseHolder<MovieEntity.SubjectsEntity> createHolder(Context context, View view) {
        return new MovicesHolder(view);
    }
}
