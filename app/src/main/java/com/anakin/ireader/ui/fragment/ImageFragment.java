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
public class ImageFragment extends BaseFragment {
    private static final ImageFragment IMAGE_FRAGMENT = new ImageFragment();

    private ImageFragment() {
    }

    @Override
    public View inflaterView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_images, container, false);
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void initData() {

    }

    public static ImageFragment getInstance() {
        return IMAGE_FRAGMENT;
    }
}
