package com.anakin.ireader.presenter.impl;
import com.anakin.ireader.model.entity.VideoEntity;
import com.anakin.ireader.model.impl.VideoModel;
import com.anakin.ireader.presenter.IVideoPresenter;
import com.anakin.ireader.presenter.listener.OnVideoListener;
import com.anakin.ireader.ui.view.IVideoView;

import java.util.List;

import javax.inject.Inject;

/**
 * 创建者     demo
 * 创建时间   2016/12/19 0019 15:18
 */
public class VideoPresenter implements IVideoPresenter, OnVideoListener {
    IVideoView mVideoView;
    private  VideoModel mModel;

    @Inject
    public VideoPresenter(IVideoView iVideoView) {
        this.mVideoView = iVideoView;
        mModel = new VideoModel();
    }
    /**
     * view 中传递参数
     */
    @Override
    public void getVideos() {
        mVideoView.showProgress();
        mModel.getVideo(this);
    }

    @Override
    public void onSuccess(List<VideoEntity.ResultsEntity> entity) {
        mVideoView.hideProgress();
        mVideoView.showVideos(entity);
    }

    @Override
    public void onFail() {
        mVideoView.hideProgress();
        mVideoView.showErrorMsg(null);
    }


}
