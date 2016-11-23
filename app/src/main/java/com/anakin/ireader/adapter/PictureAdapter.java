package com.anakin.ireader.adapter;

import android.content.Context;
import android.view.View;

import com.anakin.ireader.adapter.holder.BaseHolder;
import com.anakin.ireader.adapter.holder.PictureHolder;
import com.anakin.ireader.model.entity.PictureEntity;

import java.util.List;

/**
 * 创建者     demo
 * 创建时间   2016/11/21 0021 14:39
 */
public class PictureAdapter extends BaseAdapter<PictureEntity.ResultsEntity> {
    public PictureAdapter(Context context, List<PictureEntity.ResultsEntity> results, int res_id) {
       super(context,results,res_id);
    }

    @Override
    public BaseHolder<PictureEntity.ResultsEntity> createHolder(Context context, View view) {
        return new PictureHolder(view);
    }
}
