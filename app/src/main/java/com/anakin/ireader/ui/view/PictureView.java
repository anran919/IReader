package com.anakin.ireader.ui.view;

import com.anakin.ireader.model.entity.PictureEntity;

import java.util.List;

/**
 * 创建者     demo
 * 创建时间   2016/11/23 0023 15:10
 * <p>
 * 处理界面的显示,包括显示隐藏进度条,显示数据,错误时显示错误信息
 */
public interface PictureView {
    void showProgress();

    void hideProgress();

    void showData(List<PictureEntity.ResultsEntity> results);

    void showErroMsg();

}
