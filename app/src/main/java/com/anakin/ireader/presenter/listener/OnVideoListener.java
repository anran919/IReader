package com.anakin.ireader.presenter.listener;

import com.anakin.ireader.model.entity.VideoEntity;

import java.util.List;

/**
 * 创建者     demo
 * 创建时间   2016/12/19 0019 15:18
 */
public interface OnVideoListener  extends BaseOnLoadListener {
    void  onSuccess(List<VideoEntity.ResultsEntity> entity);
}
