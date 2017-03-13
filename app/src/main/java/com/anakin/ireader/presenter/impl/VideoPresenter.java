package com.anakin.ireader.presenter.impl;
import com.anakin.ireader.model.entity.VideoEntity;
import com.anakin.ireader.model.impl.VideoModel;
import com.anakin.ireader.presenter.OnVideoListener;
import com.anakin.ireader.presenter.IVideoPresenter;
import com.anakin.ireader.ui.fragment.VeidoFragment;

import java.util.List;

/**
 * 创建者     demo
 * 创建时间   2016/12/19 0019 15:18
 */
public class VideoPresenter implements IVideoPresenter, OnVideoListener {
    VeidoFragment mVeidoFragment;
    private final VideoModel mModel;

    public VideoPresenter(VeidoFragment veidoFragment) {
        this.mVeidoFragment = veidoFragment;
        mModel = new VideoModel();
    }
    /**
     * view 中传递参数
     */
    @Override
    public void getThings() {
        mVeidoFragment.showLoading();
        mModel.getVideo(this);
    }

    @Override
    public void onSuccess(List<VideoEntity> entity) {
        mVeidoFragment.hideLoading();
        mVeidoFragment.showVideos(entity);
    }

    @Override
    public void onFail() {
        mVeidoFragment.hideLoading();
        mVeidoFragment.showError();
    }


}
