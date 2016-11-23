package com.anakin.ireader.presenter.impl;

import com.anakin.ireader.model.entity.PictureEntity;
import com.anakin.ireader.model.impl.PictureModelImpl;
import com.anakin.ireader.presenter.OnPictureListener;
import com.anakin.ireader.presenter.PicturePresenter;
import com.anakin.ireader.ui.view.PictureView;

import java.util.List;

/**
 * 创建者     demo
 * 创建时间   2016/11/23 0023 15:19
 */
public class PicturePresenterImpl implements PicturePresenter, OnPictureListener {
    PictureView pictureView;
    private PictureModelImpl mModel;

    public PicturePresenterImpl(PictureView pictureView) {
        this.pictureView = pictureView;
        mModel = new PictureModelImpl();
    }

    @Override
    public void onSuccess(List<PictureEntity.ResultsEntity> results) {
        pictureView.hideProgress();
        pictureView.showData(results);
    }

    @Override
    public void onFail() {
        pictureView.hideProgress();
        pictureView.showErroMsg();
    }

    @Override
    public void getPicture(int count, int page) {
        pictureView.showProgress();
        mModel.loadPicture(count, page, this);
    }
}
