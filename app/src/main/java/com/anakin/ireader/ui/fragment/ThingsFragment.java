package com.anakin.ireader.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anakin.ireader.R;
import com.anakin.ireader.model.entity.ThingsEntity;
import com.anakin.ireader.presenter.impl.ThingsPresenterImpl;
import com.anakin.ireader.ui.view.ThingsView;

/**
 * 创建者     demo
 * 创建时间   2016/11/21 0021 14:43
 */
public class ThingsFragment extends BaseFragment implements ThingsView {
    @Override
    public View inflaterView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_things,container,false);
    }

    private static final ThingsFragment THINGS_FRAGMENT = new ThingsFragment();

    private ThingsFragment() {
    }

    public static ThingsFragment getInstance() {
        return THINGS_FRAGMENT;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    private void initData() {
        ThingsPresenterImpl  presenter = new ThingsPresenterImpl(this);
        presenter.getThings();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError() {

    }

    @Override
    public void setThingsInfo(ThingsEntity entity) {

    }
}
