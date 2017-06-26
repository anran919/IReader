package com.anakin.ireader.presenter.impl;

import com.anakin.ireader.model.entity.PictureEntity;
import com.anakin.ireader.model.impl.PictureModelImpl;
import com.anakin.ireader.presenter.OnPictureListener;
import com.anakin.ireader.presenter.IPicturePresenter;
import com.anakin.ireader.ui.view.IPictureView;

import java.util.List;

import javax.inject.Inject;

/**
 * 创建者     demo
 * 创建时间   2016/11/23 0023 15:19
 */
public class PicturePresenter implements IPicturePresenter, OnPictureListener {
    private PictureModelImpl mModel;

    private IPictureView mPv;

    @Inject
    public PicturePresenter(IPictureView pv) {
        this.mPv = pv;
        mModel = new PictureModelImpl();
    }

    @Override
    public void onSuccess(List<PictureEntity.ResultsEntity> results) {
        mPv.hideProgress();
        mPv.showPicture(results);
    }

    @Override
    public void onFail() {
        mPv.hideProgress();
        mPv.showErrorMsg(null);
    }

    @Override
    public void getPicture(int count, int page) {
        mPv.showProgress();
        mModel.loadPicture(count, page, this);
    }
}
