package com.anakin.ireader.base;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 创建者     demo
 * 创建时间   2016/11/19 0019 15:55
 */
public class BaseFragment extends Fragment {

    private View mRootView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);

        return mRootView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public <V extends View> V getView(int id){
        return (V) mRootView.findViewById(id);
    }
}
