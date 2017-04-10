package com.anakin.ireader.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.anakin.ireader.R;
import com.anakin.ireader.adapter.VideoAdapter;
import com.anakin.ireader.adapter.holder.VideoHolder;
import com.anakin.ireader.di.component.DaggerVideoComponent;
import com.anakin.ireader.di.module.VideoModule;
import com.anakin.ireader.model.entity.VideoEntity;
import com.anakin.ireader.presenter.impl.VideoPresenter;
import com.anakin.ireader.ui.view.IVideoView;
import com.anakin.ireader.widget.VideoItemDecoration;
import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.shuyu.gsyvideoplayer.GSYVideoPlayer;
import com.shuyu.gsyvideoplayer.utils.ListVideoUtil;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 创建者     demo
 * 创建时间   2016/11/21 0021 14:43
 */
public class VideoFragment extends BaseFragment implements IVideoView {

    @Bind(R.id.rl_list_video)
    RelativeLayout mRelativeLayout;
    @Bind(R.id.video_list)
    RecyclerView list;
    @Bind(R.id.video_full_container)
    FrameLayout videoFullContainer;

    @Inject
    VideoPresenter presenter;

    private ListVideoUtil mVideoUtil;
    private VideoAdapter mAdapter;

    private LinearLayoutManager mLinearLayoutManager;


    @Override
    public View inflaterView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_things, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    private static final VideoFragment THINGS_FRAGMENT = new VideoFragment();

    private VideoFragment() {
    }

    public static VideoFragment getInstance() {
        return THINGS_FRAGMENT;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    private void initData() {
        //视屏相关
        mVideoUtil = new ListVideoUtil(mContext);
        mVideoUtil.setFullViewContainer(videoFullContainer);
        mVideoUtil.setHideStatusBar(true);
        //mVideoUtil.setHideActionBar(true);
        mVideoUtil.setNeedLockFull(true);


        // Dagger2
        DaggerVideoComponent.builder()
                .videoModule(new VideoModule(this))
                .build()
                .inject(this);

        presenter.getThings();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError() {
        Toast.makeText(mContext,R.string.load_fail,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showVideos(List<VideoEntity.ResultsEntity> entity) {
        // Adapter
        mAdapter = new VideoAdapter(mContext,entity, R.layout.item_list_video);
        mLinearLayoutManager = new LinearLayoutManager(mContext);
        list.setLayoutManager(mLinearLayoutManager);
        list.addItemDecoration(new VideoItemDecoration(0,10));
        list.setAdapter(mAdapter);

        list.addOnScrollListener(new RecyclerView.OnScrollListener() {
            int firstVisibleItem, lastVisibleItem;
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                firstVisibleItem   = mLinearLayoutManager.findFirstVisibleItemPosition();
                lastVisibleItem = mLinearLayoutManager.findLastVisibleItemPosition();
                //大于0说明有播放
                if (GSYVideoManager.instance().getPlayPosition() >= 0) {
                    //当前播放的位置
                    int position = GSYVideoManager.instance().getPlayPosition();
                    //对应的播放列表TAG
                    if (GSYVideoManager.instance().getPlayTag().equals(VideoHolder.TAG)
                            && (position < firstVisibleItem || position > lastVisibleItem)) {
                        //如果滑出去了上面和下面就是否，和今日头条一样
                        GSYVideoPlayer.releaseAllVideos();
                        mAdapter.notifyDataSetChanged();
                    }
                }
            }
        });
    }


    @Override
    public void onPause() {
        super.onPause();
        GSYVideoManager.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        GSYVideoManager.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        GSYVideoPlayer.releaseAllVideos();
    }
}
