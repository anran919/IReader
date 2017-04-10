package com.anakin.ireader.presenter.impl;
import com.anakin.ireader.model.entity.VideoEntity;
import com.anakin.ireader.model.impl.VideoModel;
import com.anakin.ireader.presenter.IVideoPresenter;
import com.anakin.ireader.presenter.OnVideoListener;
import com.anakin.ireader.ui.fragment.VideoFragment;

import java.util.List;

import javax.inject.Inject;

/**
 * 创建者     demo
 * 创建时间   2016/12/19 0019 15:18
 */
public class VideoPresenter implements IVideoPresenter, OnVideoListener {
    VideoFragment mVideoFragment;
    private final VideoModel mModel;

    @Inject
    public VideoPresenter(VideoFragment videoFragment) {
        this.mVideoFragment = videoFragment;
        mModel = new VideoModel();
    }
    /**
     * view 中传递参数
     */
    @Override
    public void getThings() {
        mVideoFragment.showLoading();
        mModel.getVideo(this);
    }

    @Override
    public void onSuccess(List<VideoEntity.ResultsEntity> entity) {
        mVideoFragment.hideLoading();
        mVideoFragment.showVideos(entity);
    }

    @Override
    public void onFail() {
        mVideoFragment.hideLoading();
        mVideoFragment.showError();
    }


}
