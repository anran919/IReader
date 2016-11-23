package com.anakin.ireader.model;

import com.anakin.ireader.presenter.OnPictureListener;

/**
 * 创建者     demo
 * 创建时间   2016/11/23 0023 15:22
 */
public interface PictureModel {
    void loadPicture(int count, int page, OnPictureListener pictureListener);
}
