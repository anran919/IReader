package com.anakin.ireader.base;

/**
 * 创建者     demo
 * 创建时间   2017/6/26 0026 10:45
 */
public class TestActivity extends MvpActivity<TestView,TestPreseter> {


    @Override
    protected TestPreseter initPresenter() {
        return null;
    }

    @Override
    public int getLayoutId() {
        return 0;
    }

    @Override
    protected void initView() {

    }
}
