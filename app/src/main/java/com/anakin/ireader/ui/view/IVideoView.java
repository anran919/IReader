package com.anakin.ireader.ui.view;

import com.anakin.ireader.model.entity.VideoEntity;

import java.util.List;

/**
 * 创建者     demo
 * 创建时间   2016/12/19 0019 15:07
 */
public interface IVideoView {
    void showLoading();
    void hideLoading();
    void showError();
    void showVideos(List<VideoEntity.ResultsEntity> entity);
}
