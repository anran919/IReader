package com.anakin.ireader.base;

import android.os.Bundle;
import android.os.PersistableBundle;

import com.anakin.ireader.ui.activity.BaseActivity;

/**
 * 创建者     demo
 * 创建时间   2017/6/26 0026 10:06
 */
public abstract class MvpActivity<V,P extends BasePresenter<V>> extends BaseActivity{

    protected P presenter;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        presenter = initPresenter();
    }


    @Override
    protected void onResume() {
        super.onResume();
        presenter.attach((V) this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.deatch();
    }

    protected abstract P initPresenter();
}
