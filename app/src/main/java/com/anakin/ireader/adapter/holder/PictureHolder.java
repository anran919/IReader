package com.anakin.ireader.adapter.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.anakin.ireader.R;
import com.anakin.ireader.model.entity.PictureEntity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 创建者     demo
 * 创建时间   2016/11/21 0021 14:41
 */
public class PictureHolder extends BaseHolder<PictureEntity.ResultsEntity> {
    private View mItemView;
    @Bind(R.id.iv_picture)
    ImageView picture;
    @Bind(R.id.tv_desc)
    TextView mDesc;

    public PictureHolder(View itemView) {
        super(itemView);
        this.mItemView = itemView;
        ButterKnife.bind(this, mItemView);
    }

    @Override
    public void setData(PictureEntity.ResultsEntity results, int position) {

       /* Transformation transformation = new Transformation() {
            @Override
            public Bitmap transform(Bitmap source) {
                int targetWidth = picture.getWidth();
                if (source.getWidth() == 0) {
                    return source;
                }
                //如果图片小于设置的宽度，则返回原图
                if (source.getWidth() < targetWidth) {
                    return source;
                } else {
                    //如果图片大小大于等于设置的宽度，则按照设置的宽度比例来缩放
                    double aspectRatio = (double) source.getHeight() / (double) source.getWidth();
                    int targetHeight = (int) (targetWidth * aspectRatio);
                    if (targetHeight != 0 && targetWidth != 0) {
                        Bitmap result = Bitmap.createScaledBitmap(source, targetWidth, targetHeight, false);
                        if (result != source) {
                            // Same bitmap is returned if sizes are the same
                            source.recycle();
                        }
                        return result;
                    } else {
                        return source;
                    }
                }
            }

            @Override
            public String key() {
                return "transformation" + " desiredWidth";
            }
        };*/
        String url = results.getUrl();
        String desc = results.getDesc();

        Glide.with(itemView.getContext()).load(url)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .placeholder(R.mipmap.picture_error_pic)
                .error(R.mipmap.picture_error_pic)
                .centerCrop().override(1090, 1090*3/4)
                .crossFade().into(picture);


/*        Picasso.with(itemView.getContext())
                .load(url)
                .error(R.mipmap.picture_error_pic)
                .placeholder(R.mipmap.picture_error_pic)
//                .resize(500,809)  // 裁剪
//                .fit()
//                .centerCrop()
                .transform(transformation)  //等比加载图片
                .into(picture);*/
        mDesc.setText(desc);
    }
}
