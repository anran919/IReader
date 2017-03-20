package com.anakin.ireader.adapter.holder;

import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.anakin.ireader.R;
import com.anakin.ireader.model.entity.PictureEntity;
import com.anakin.ireader.ui.activity.PhotosDetailActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.animation.ViewPropertyAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

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

        final String url = results.getUrl();
        String desc = results.getDesc();

/*        Transformation transformation = new Transformation() {
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
        };

                Picasso.with(itemView.getContext())
                .load(url)
                .error(R.mipmap.picture_error_pic)
                .placeholder(R.mipmap.picture_error_pic)
//                .resize(500,809)  // 裁剪
//                .fit()
//                .centerCrop()
                .transform(transformation)  //等比加载图片
                .into(picture);*/

        SimpleTarget<Bitmap> target = new SimpleTarget<Bitmap>() {

            @Override
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {

            }
        };

        ViewPropertyAnimation.Animator animator = new ViewPropertyAnimation.Animator() {
            @Override
            public void animate(View view) {
                // 设置动画
                view.setAlpha(0f);
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 0f, 1f);
                ofFloat.setDuration(300);
                ofFloat.start();
            }
        };


        // 图片等比加载
        Glide.with(itemView.getContext())
                .load(url)
//                .asBitmap()
                .thumbnail(0.5f) // 加载缩略图
                .placeholder(R.mipmap.testimg)  // 占位符
                .error(R.mipmap.picture_error_pic) // will be displayed if the image cannot be loaded
//                .crossFade()  // 动画效果,默认
//                .animate(android.R.anim.slide_in_left) // 自定义动画 xml
                .animate(animator) // 通过自定义类实现动画
//                .dontAnimate() // 不使用任何动画
//                .override(600, 200)// 设置图片的大小
//                .transform(new BlurTransformation(itemView.getContext()))
                .diskCacheStrategy(DiskCacheStrategy.SOURCE) // 缓存图片的种类
                .into(picture);
              /*  .into(new BitmapImageViewTarget(picture) {
            @Override
            protected void setResource(Bitmap resource) {
                super.setResource(resource);
                int targetWidth = picture.getWidth();
                //如果图片大小大于等于设置的宽度，则按照设置的宽度比例来缩放
                double aspectRatio = (double) resource.getHeight() / (double) resource.getWidth();
                int targetHeight = (int) (targetWidth * aspectRatio);
                if (targetHeight != 0 && targetWidth != 0) {
                    Bitmap result = Bitmap.createScaledBitmap(resource, targetWidth, targetHeight, false);
                    if (result != resource) {
                        // Same bitmap is returned if sizes are the same
                        resource.recycle();
                        ViewGroup.LayoutParams params = picture.getLayoutParams();
                        params.height = targetHeight;
                        picture.setLayoutParams(params);
                    }
                }else {

                }
            }
        });*/


//        Glide.with(itemView.getContext()).load(url)
//                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
//                .placeholder(R.mipmap.picture_error_pic)
//                .error(R.mipmap.picture_error_pic)
//                .centerCrop().override(1090, 1090*3/4)
//                .crossFade().into(picture);
        mDesc.setText(desc);

        mItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PhotosDetailActivity.startAction(itemView.getContext(), url);
            }
        });
    }
}
