package com.anakin.ireader.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anakin.ireader.R;
import com.anakin.ireader.adapter.BaseAdapter;
import com.anakin.ireader.adapter.holder.BaseHolder;
import com.anakin.ireader.adapter.holder.MainListHolder;
import com.anakin.ireader.bean.ListItem;
import com.anakin.ireader.ui.view.ContentListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 创建者     demo
 * 创建时间   2016/11/19 0019 17:59
 */

public class ContentListFragment extends Fragment implements ContentListView {

    @Bind(R.id.recyclerview)
    RecyclerView mRecyclerview;
    @Bind(R.id.refresh)
    SwipeRefreshLayout mRefresh;
    private BaseAdapter mAdapter;
    private List<String> mDatas;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fregment_article, container, false);
        ButterKnife.bind(this, view);
        mDatas = new ArrayList<>();
        initRecyclerView();
        return view;
    }

    private void initRecyclerView() {
     mAdapter= new BaseAdapter<String>(this.getContext(),mDatas,R.layout.list_item){

         @Override
         public BaseHolder<String> createHolder(Context context, View view) {
             return new MainListHolder(view);
         }
     };

        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext());
        mRecyclerview.setAdapter(mAdapter);
        mRecyclerview.setLayoutManager(layoutManager);
        mRecyclerview.setVerticalScrollBarEnabled(true);
        mRecyclerview.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }

    @Override
    public void showDatas(List<ListItem> dailies) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showMsg(String msg) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
