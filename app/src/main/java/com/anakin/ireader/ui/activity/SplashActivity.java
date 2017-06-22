package com.anakin.ireader.ui.activity;

import android.content.Intent;
import android.os.Handler;

import com.anakin.ireader.R;

/**
 * Created by demo on 2017/6/17 0017
 */
public class SplashActivity extends BaseActivity {

    private static final long SPLASH_DISPLAY_TIME = 1000;

    @Override
    public int getLayoutId() {
        return R.layout.act_splash;
    }

    @Override
    protected void initView() {
       new Handler().postDelayed(new Runnable() {
           @Override
           public void run() {
               Intent intent = new Intent(SplashActivity.this,
                       LoginActivity.class);
               startActivity(intent);
               SplashActivity.this.finish();
           }
       }, SPLASH_DISPLAY_TIME);
    }

}
