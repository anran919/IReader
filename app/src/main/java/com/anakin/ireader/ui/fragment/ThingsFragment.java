package com.anakin.ireader.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anakin.ireader.R;

/**
 * 创建者     demo
 * 创建时间   2016/11/21 0021 14:43
 */
public class ThingsFragment extends BaseFragment {
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
}
