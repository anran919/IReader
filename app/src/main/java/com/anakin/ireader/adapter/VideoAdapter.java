package com.anakin.ireader.adapter;

import android.content.Context;
import android.view.View;

import com.anakin.ireader.adapter.holder.BaseHolder;
import com.anakin.ireader.adapter.holder.VideoHolder;
import com.anakin.ireader.model.entity.VideoEntity;

import java.util.List;

/**
 * 创建者     demo
 * 创建时间   2016/11/21 0021 14:40
 */
public class VideoAdapter extends BaseAdapter<VideoEntity.ResultsEntity> {
    public VideoAdapter(Context context, List<VideoEntity.ResultsEntity> datas, int res_id) {
        super(context,datas, res_id);
    }

    @Override
    public BaseHolder<VideoEntity.ResultsEntity> createHolder(Context context, View view) {
        return new VideoHolder(context,view);
    }
}
