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
public class QuestionsFragment extends BaseFragment {

    private static final QuestionsFragment QUESTIONS_FRAGMENT = new QuestionsFragment();

    private QuestionsFragment() {
    }

    @Override
    public View inflaterView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_questions, container, false);
    }

    @Override
    protected void initView() {

    }

    public static QuestionsFragment getInstance() {
        return QUESTIONS_FRAGMENT;
    }


    @Override
    public void onRefresh() {

    }
}
