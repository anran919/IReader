package com.anakin.ireader.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.anakin.ireader.R;
import com.anakin.ireader.adapter.VideoAdapter;
import com.anakin.ireader.adapter.holder.VideoHolder;
import com.anakin.ireader.listener.SampleListener;
import com.anakin.ireader.model.entity.VideoEntity;
import com.anakin.ireader.presenter.impl.VideoPresenter;
import com.anakin.ireader.ui.view.IVideoView;
import com.shuyu.gsyvideoplayer.utils.Debuger;
import com.shuyu.gsyvideoplayer.utils.ListVideoUtil;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 创建者     demo
 * 创建时间   2016/11/21 0021 14:43
 */
public class VeidoFragment extends BaseFragment implements IVideoView {

    private static final String TAG ="VeidoFragment" ;
    @Bind(R.id.rl_list_video)
    RelativeLayout mRelativeLayout;
    @Bind(R.id.video_list)
    RecyclerView list;
    @Bind(R.id.video_full_container)
    FrameLayout videoFullContainer;
    private ListVideoUtil mVideoUtil;
    private VideoAdapter mAdapter;

    int lastVisibleItem;
    int firstVisibleItem;


    @Override
    public View inflaterView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_things, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    private static final VeidoFragment THINGS_FRAGMENT = new VeidoFragment();

    private VeidoFragment() {
    }

    public static VeidoFragment getInstance() {
        return THINGS_FRAGMENT;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // 设置一个exit transition
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            Window window = this.getActivity().getWindow();
//            window.requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
//            window.setEnterTransition(new Explode());
//            window.setExitTransition(new Explode());
//        }
        initData();
    }

    private void initData() {
        VideoPresenter presenter = new VideoPresenter(this);
        presenter.getThings();

        //视屏相关
        mVideoUtil = new ListVideoUtil(mContext);
        mVideoUtil.setFullViewContainer(videoFullContainer);
        mVideoUtil.setHideStatusBar(true);
        //mVideoUtil.setHideActionBar(true);
        mVideoUtil.setNeedLockFull(true);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError() {

    }

    @Override
    public void showVideos(List<VideoEntity> entity) {

        Log.d(TAG," ==== show Video ====="+entity.toString());
        // Adapter
        mAdapter = new VideoAdapter(mContext,entity, R.layout.item_list_video);
        list.setLayoutManager(new LinearLayoutManager(mContext));
        list.setAdapter(mAdapter);



       /* list.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                VeidoFragment.this.firstVisibleItem = firstVisibleItem;
                lastVisibleItem = firstVisibleItem + visibleItemCount;
                //大于0说明有播放,//对应的播放列表TAG
                if (mVideoUtil.getPlayPosition() >= 0 && mVideoUtil.getPlayTAG().equals("TT2")) {
                    //当前播放的位置
                    int position = mVideoUtil.getPlayPosition();
                    //不可视的是时候
                    if ((position < firstVisibleItem || position > lastVisibleItem)) {
                        //如果是小窗口就不需要处理
                        if (!mVideoUtil.isSmall()) {
                            //小窗口
                            int size = CommonUtil.dip2px(mContext, 150);
                            mVideoUtil.showSmallVideo(new Point(size, size), false, true);
                        }
                    } else {
                        if (mVideoUtil.isSmall()) {
                            mVideoUtil.smallVideoToNormal();
                        }
                    }
                }
            }

        });
*/
        //小窗口关闭被点击的时候回调处理回复页面
        mVideoUtil.setVideoAllCallBack(new SampleListener(){
            @Override
            public void onPrepared(String url, Object... objects) {
                super.onPrepared(url, objects);
                Debuger.printfLog("Duration " + mVideoUtil.getDuration() + " CurrentPosition " + mVideoUtil.getCurrentPositionWhenPlaying());
            }

            @Override
            public void onQuitSmallWidget(String url, Object... objects) {
                super.onQuitSmallWidget(url, objects);
                //大于0说明有播放,//对应的播放列表TAG
                if (mVideoUtil.getPlayPosition() >= 0 && mVideoUtil.getPlayTAG().equals(VideoHolder.TAG)) {
                    //当前播放的位置
                    int position = mVideoUtil.getPlayPosition();
                    //不可视的是时候
                    if ((position < firstVisibleItem || position > lastVisibleItem)) {
                        //释放掉视频
                        mVideoUtil.releaseVideoPlayer();
                        mAdapter.notifyDataSetChanged();
                    }
                }

            }
        });

    }
}
