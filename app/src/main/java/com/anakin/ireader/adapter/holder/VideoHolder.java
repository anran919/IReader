package com.anakin.ireader.adapter.holder;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.anakin.ireader.R;
import com.anakin.ireader.model.entity.VideoEntity;
import com.shuyu.gsyvideoplayer.utils.ListVideoUtil;

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

    @Bind(R.id.list_item_container)
    FrameLayout videoContainer;

    @Bind(R.id.list_item_btn)
    ImageView playerBtn;
    private ListVideoUtil mVideoUtil;


    public VideoHolder(Context context, View itemView) {
        super(itemView);
        this.mContext = context;
        this.mItemView = itemView;
        ButterKnife.bind(this, mItemView);
    }

    @Override
    public void setData(final VideoEntity data) {
        ImageView imageView = new ImageView(mContext);
        final int position = getLayoutPosition();

        //增加封面
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(R.mipmap.ic_launcher);

        mVideoUtil = new ListVideoUtil(mContext);
        mVideoUtil.addVideoPlayer(position, imageView, TAG, videoContainer, playerBtn);

        playerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                notifyDataSetChanged();
                //listVideoUtil.setLoop(true);
                mVideoUtil.setPlayPositionAndTag(position, TAG);
                final String url = data.getVideo_url();
                //listVideoUtil.setCachePath(new File(FileUtils.getPath()));
                mVideoUtil.startPlay(url);
            }
        });

    }
}
