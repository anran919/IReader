package com.anakin.ireader.presenter.listener;

import com.anakin.ireader.model.entity.PictureEntity;

import java.util.List;

/**
 * 创建者     demo
 * 创建时间   2016/11/23 0023 15:19
 */
public interface OnPictureListener extends BaseOnLoadListener {
    void onSuccess(List<PictureEntity.ResultsEntity> results);
}
