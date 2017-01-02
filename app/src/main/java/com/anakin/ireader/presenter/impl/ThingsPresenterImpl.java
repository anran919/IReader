package com.anakin.ireader.presenter.impl;
import com.anakin.ireader.model.entity.ThingsEntity;
import com.anakin.ireader.model.impl.ThingsModelImpl;
import com.anakin.ireader.presenter.OnThingsListener;
import com.anakin.ireader.presenter.ThingsPresenter;
import com.anakin.ireader.ui.fragment.ThingsFragment;

/**
 * 创建者     demo
 * 创建时间   2016/12/19 0019 15:18
 */
public class ThingsPresenterImpl implements ThingsPresenter, OnThingsListener {
    ThingsFragment mThingsFragment;
    private final ThingsModelImpl mModel;

    public ThingsPresenterImpl(ThingsFragment thingsFragment) {
        this.mThingsFragment = thingsFragment;
        mModel = new ThingsModelImpl();
    }
    /**
     * view 中传递参数
     */
    @Override
    public void getThings() {
        mThingsFragment.showLoading();
        mModel.getThings(this);
    }

    @Override
    public void onSuccess(ThingsEntity entity) {
        mThingsFragment.hideLoading();
        mThingsFragment.setThingsInfo(entity);
    }

    @Override
    public void onFail() {
        mThingsFragment.hideLoading();
        mThingsFragment.showError();
    }


}
