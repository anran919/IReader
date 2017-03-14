package com.anakin.ireader.adapter.holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.anakin.ireader.R;
import com.anakin.ireader.listener.SampleListener;
import com.anakin.ireader.model.entity.VideoEntity;
import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.shuyu.gsyvideoplayer.utils.Debuger;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 创建者     demo
 * 创建时间   2016/11/21 0021 14:41
 */
public class VideoHolder extends BaseHolder<VideoEntity> {
    public final static String TAG = "TT2";

    private View mItemView;
    private Context mContext;

    @Bind(R.id.video_item_player)
    StandardGSYVideoPlayer gsyVideoPlayer;




    public VideoHolder(Context context, View itemView) {
        super(itemView);
        this.mContext = context;
        this.mItemView = itemView;
        ButterKnife.bind(this, mItemView);
    }

    @Override
    public void setData(final VideoEntity data) {
        int position = getAdapterPosition();
        //增加封面
        ImageView imageView = new ImageView(mContext);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        if (position % 2 == 0) {
            imageView.setImageResource(R.mipmap.testimg);
        } else {
            imageView.setImageResource(R.mipmap.testimg);
        }
        if (imageView.getParent() != null) {
            ViewGroup viewGroup = (ViewGroup)imageView.getParent();
            viewGroup.removeView(imageView);
        }
        gsyVideoPlayer.setThumbImageView(imageView);

        final String url = data.getVideo_url();

        //默认缓存路径
        gsyVideoPlayer.setUp(url, true , null, "这是title");

        //增加title
        gsyVideoPlayer.getTitleTextView().setVisibility(View.GONE);

        //设置返回键
        gsyVideoPlayer.getBackButton().setVisibility(View.GONE);

        //设置全屏按键功能
        gsyVideoPlayer.getFullscreenButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resolveFullBtn(gsyVideoPlayer);
            }
        });
        gsyVideoPlayer.setRotateViewAuto(true);
        gsyVideoPlayer.setLockLand(true);
        gsyVideoPlayer.setPlayTag(TAG);
        gsyVideoPlayer.setShowFullAnimation(true);
        //循环
        //gsyVideoPlayer.setLooping(true);
        gsyVideoPlayer.setNeedLockFull(true);

        //gsyVideoPlayer.setSpeed(2);

        gsyVideoPlayer.setPlayPosition(position);

        gsyVideoPlayer.setStandardVideoAllCallBack(new SampleListener(){
            @Override
            public void onPrepared(String url, Object... objects) {
                super.onPrepared(url, objects);
                Debuger.printfLog("onPrepared");
                if (!gsyVideoPlayer.isIfCurrentIsFullscreen()) {
                    //静音
                    GSYVideoManager.instance().setNeedMute(true);
                }

            }

            @Override
            public void onQuitFullscreen(String url, Object... objects) {
                super.onQuitFullscreen(url, objects);
                //全屏不静音
                GSYVideoManager.instance().setNeedMute(true);
            }

            @Override
            public void onEnterFullscreen(String url, Object... objects) {
                super.onEnterFullscreen(url, objects);
                GSYVideoManager.instance().setNeedMute(false);
            }
        });
    }


    /**
     * 全屏幕按键处理
     */
    private void resolveFullBtn(final StandardGSYVideoPlayer standardGSYVideoPlayer) {
        standardGSYVideoPlayer.startWindowFullscreen(mContext, true, true);
    }

}
