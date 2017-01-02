package com.anakin.ireader.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.anakin.ireader.R;
import com.anakin.ireader.adapter.ArticleAdapter;
import com.anakin.ireader.helper.ArticleItemDecoration;
import com.anakin.ireader.model.entity.ListItem;
import com.anakin.ireader.presenter.ArticlePresenter;
import com.anakin.ireader.presenter.ListPresenter;
import com.anakin.ireader.ui.view.ArticleView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 创建者     demo
 * 创建时间   2016/11/21 0021 14:43
 */
public class ArticleFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener ,ArticleView {
    private static final ArticleFragment ARTICLE_FRAGMENT = new ArticleFragment();
    private static final String TAG = "ArticleFragment";
    @Bind(R.id.recyclerview_articel)
    RecyclerView mRecyclerView;
    @Bind(R.id.swrfresh)
    SwipeRefreshLayout mSwipeRefreshLayout;
    List<String> datas;
    private ArticleAdapter mArticleAdapter;
    private LinearLayoutManager mLayoutManager;
    private ListPresenter mPresenter;


    @Override
    public View inflaterView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_articel, container, false);
        ButterKnife.bind(this, rootView);
        initData();
        return rootView;
    }

    protected void initData() {
        initRecyclerView();
        initPresenter();
    }

    private void initPresenter() {
        mPresenter = ArticlePresenter.getInstance();
        mPresenter.attachView(this);
    }

    private void initRecyclerView() {
        datas = new ArrayList<>(80);
        for (int i = 0; i < 80; i++) {
            datas.add("黄粱一梦二十年 依旧是不懂爱也不懂情 写歌的人假正经啊 听歌的人最无情" + i);
        }
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mArticleAdapter = new ArticleAdapter(mContext, datas, R.layout.item_article);
        ArticleItemDecoration  decoration = new ArticleItemDecoration();
        mRecyclerView.addItemDecoration(decoration);
        mRecyclerView.setAdapter(mArticleAdapter);
        mRecyclerView.setVerticalScrollBarEnabled(true);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter.loadListDates();
    }


    public static ArticleFragment getInstance() {
        return ARTICLE_FRAGMENT;
    }

    /**
     * 下拉刷新
     */
    @Override
    public void onRefresh() {
        Toast.makeText(mContext, "刷新数据", Toast.LENGTH_SHORT).show();
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
}
