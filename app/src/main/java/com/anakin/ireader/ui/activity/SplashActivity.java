package com.anakin.ireader.ui.activity;

import android.Manifest;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.anakin.ireader.R;
import com.anakin.ireader.presenter.ISplashPresenter;
import com.anakin.ireader.presenter.impl.SplashPresenter;
import com.anakin.ireader.ui.view.ISplashView;

import java.util.List;
import java.util.Random;

import butterknife.Bind;

/**
 * Created by demo on 2017/6/17 0017
 */
public class SplashActivity extends BaseActivity implements ISplashView {
    private static final int ANIMATION_DURATION = 2000;
    private static final float SCALE_END = 1.13F;
    @Bind(R.id.iv_entry)
    ImageView mSplashImage;
    @Bind(R.id.tv_title)
    TextView titleView;
    private ISplashPresenter mPresenter;

    @Override
    public int getLayoutId() {
        return R.layout.act_splash;
    }

    @Override
    protected void initView() {
        mPresenter = new SplashPresenter();
        mPresenter.attach(this);
        mPresenter.getImage();
    }

    @Override
    public void setSplashView(List<Integer> results) {
        Random r = new Random(SystemClock.elapsedRealtime());
        mSplashImage.setImageResource(results.get(r.nextInt(results.size())));
        animateImage();
//        applyBlur();
        ActivityCompat.requestPermissions(this,
                new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
    }

    private void animateImage() {
        ObjectAnimator animatorX = ObjectAnimator.ofFloat(mSplashImage, View.SCALE_X, 1f, SCALE_END);
        ObjectAnimator animatorY = ObjectAnimator.ofFloat(mSplashImage, View.SCALE_Y, 1f, SCALE_END);

        AnimatorSet set = new AnimatorSet();
        set.setDuration(ANIMATION_DURATION).play(animatorX).with(animatorY);
        set.start();

        set.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                startActivity(new Intent(SplashActivity.this,LoginActivity.class));
                SplashActivity.this.finish();
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.deatch();
    }
}
