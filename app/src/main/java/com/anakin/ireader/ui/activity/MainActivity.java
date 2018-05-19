package com.anakin.ireader.ui.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.IdRes;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

import com.anakin.ireader.R;
import com.anakin.ireader.adapter.ContentPagerAdapter;
import com.anakin.ireader.helper.constants.PagerConfig;
import com.anakin.ireader.helper.utils.ShareUtils;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import butterknife.Bind;

/**
 * Created by demo on 2017/6/17 0017
 */
public class MainActivity extends BaseActivity implements View.OnClickListener, OnTabSelectListener {
    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private static final String TAG = "MainActivity";

    @Bind(R.id.bottomBar)
    BottomBar bottomBar; //viewpager_activity_main
    @Bind(R.id.viewpager_activity_main)
    ViewPager mViewPager;
    @Bind(R.id.fab_action_share)
    FloatingActionButton mShare;
    @Bind(R.id.fab_action_camera)
    FloatingActionButton mCamera;
    @Bind(R.id.fab)
    FloatingActionsMenu mFatMenu;
    private Bitmap mImageBitmap;

    @Override
    public int getLayoutId() {
        return R.layout.act_login;
    }

    @Override
    protected void initView() {
        ContentPagerAdapter pagerAdapter = new ContentPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(pagerAdapter);
        mViewPager.setOffscreenPageLimit(PagerConfig.titles.length); //超出屏幕的限制
        initFloatingActionButton();
    }


    @Override
    public void initEvent() {
        super.initEvent();
        bottomBar.setOnTabSelectListener(this);
    }


    @Override
    public void onTabSelected(@IdRes int tabId) {

        switch (tabId) {
            case R.id.tab_recents:
                mViewPager.setCurrentItem(0);
                break;
            case R.id.tab_favorites:
                mViewPager.setCurrentItem(1);
                break;
            case R.id.tab_nearby:
                mViewPager.setCurrentItem(2);
                break;
            case R.id.tab_friends:
                mViewPager.setCurrentItem(3);
                break;
            case R.id.tab_food:
                mViewPager.setCurrentItem(4);
                break;
        }

    }

    private void initFloatingActionButton() {
        mShare.setOnClickListener(this);
        mCamera.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fab_action_share:
                ShareUtils.getInstance(this).showShare();
                break;
            case R.id.fab_action_camera:
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                }
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            mImageBitmap = (Bitmap) extras.get("data");
            Log.d(TAG, " mImageBitmap" + mImageBitmap.toString());
//            mThumbView.setImageBitmap(mImageBitmap);
        }
    }
}
