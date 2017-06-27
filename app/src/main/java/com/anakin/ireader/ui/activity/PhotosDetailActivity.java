package com.anakin.ireader.ui.activity;

import android.content.Context;
import android.content.Intent;

import com.anakin.ireader.R;
import com.anakin.ireader.helper.constants.AppConstant;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import butterknife.Bind;
import uk.co.senab.photoview.PhotoView;

/**
 * Created by demo on 2017/3/20 0020
 */
public class PhotosDetailActivity extends BaseActivity {

    @Bind(R.id.photoView)
    PhotoView mPhotoView;

    public static void startAction(Context context, String url){
        Intent intent = new Intent(context, PhotosDetailActivity.class);
        intent.putExtra(AppConstant.PHOTO_DETAIL,url);
        context.startActivity(intent);
    }


    @Override
    public int getLayoutId() {
        return R.layout.act_photo_detail;
    }


    @Override
    protected void initView() {
        String url = getIntent().getStringExtra(AppConstant.PHOTO_DETAIL);
        Glide.with(this).load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .error(R.mipmap.picture_error_pic)
                .crossFade().into(mPhotoView);
    }
}
