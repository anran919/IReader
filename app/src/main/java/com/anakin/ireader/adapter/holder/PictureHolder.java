package com.anakin.ireader.adapter.holder;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.anakin.ireader.R;
import com.anakin.ireader.model.entity.PictureEntity;
import com.squareup.picasso.Picasso;

/**
 * 创建者     demo
 * 创建时间   2016/11/21 0021 14:41
 */
public class PictureHolder extends BaseHolder<PictureEntity.ResultsEntity> {
    private  final String TAG = "PictureHolder";
    private ImageView mPicture;
    private View itemView;

    //    @Bind(R.id.iv_picture)
//    ImageView picture;

    public PictureHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;
//        ButterKnife.bind(this, itemView);
        mPicture = (ImageView) itemView.findViewById(R.id.iv_picture);
    }

    @Override
    public void setData(PictureEntity.ResultsEntity results) {
        String url = results.getUrl();
        Log.e(TAG,"url --------> "+url);

        Picasso.with(itemView.getContext())
                .load(url)
                .error(R.mipmap.picture_error_pic)
                .fit()
                .centerCrop()
                .into(mPicture);

        Log.e(TAG,"url --------> "+results);

    }
}
