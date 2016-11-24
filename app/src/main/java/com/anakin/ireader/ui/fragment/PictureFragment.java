package com.anakin.ireader.ui.fragment;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.anakin.ireader.R;
import com.anakin.ireader.adapter.PictureAdapter;
import com.anakin.ireader.model.entity.PictureEntity;
import com.anakin.ireader.presenter.PicturePresenter;
import com.anakin.ireader.presenter.impl.PicturePresenterImpl;
import com.anakin.ireader.ui.view.PictureView;
import com.anakin.ireader.widget.PictureItemDecoration;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 创建者     demo
 * 创建时间   2016/11/21 0021 14:43
 */
public class PictureFragment extends BaseFragment implements PictureView, SwipeRefreshLayout.OnRefreshListener {
    private static final PictureFragment PICTURE_FRAGMENT = new PictureFragment();
    private static final String TAG = "PictureFragment";
    @Bind(R.id.recyclerview_articel)
    RecyclerView mRecyclerView;
    @Bind(R.id.swrfresh)
    SwipeRefreshLayout mSwrfresh;
    private PicturePresenter mPresenter;
    private ProgressDialog mProgressDialog;
    private StaggeredGridLayoutManager mManager;

    private PictureFragment() {
    }

    @Override
    public View inflaterView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_picture, container, false);
        ButterKnife.bind(this, rootView);
        initView();
        return rootView;
    }

    private void initView() {
        // 初始化界面
        mSwrfresh.setColorSchemeColors(Color.BLUE,
                Color.GREEN,
                Color.YELLOW,
                Color.RED);
        // 设置手指在屏幕下拉多少距离会触发下拉刷新
        mSwrfresh.setDistanceToTriggerSync(300);
        // 设定下拉圆圈的背景
        mSwrfresh.setProgressBackgroundColorSchemeColor(Color.WHITE);
        // 设置圆圈的大小
        mSwrfresh.setSize(SwipeRefreshLayout.LARGE);
        //设置下拉刷新的监听
        mSwrfresh.setOnRefreshListener(this);

        mPresenter = new PicturePresenterImpl(this);

        mProgressDialog = new ProgressDialog(mContext);
        mProgressDialog.setTitle("一大波妹子正在袭来.....");
    }

    public static PictureFragment getInstance() {
        return PICTURE_FRAGMENT;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter.getPicture(20, 1);
    }

    @Override
    public void showProgress() {
        mProgressDialog.show();
    }

    @Override
    public void hideProgress() {
        mProgressDialog.dismiss();
    }

    @Override
    public void showData(List<PictureEntity.ResultsEntity> results) {
        PictureAdapter adapter = new PictureAdapter(mContext, results, R.layout.item_picture);
        mManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mManager);
        mRecyclerView.setAdapter(adapter);
        PictureItemDecoration decor = new PictureItemDecoration(5);
        mRecyclerView.addItemDecoration(decor);

    }

    @Override
    public void showErroMsg() {
        Toast.makeText(mContext, "妹子不见了...(┬＿┬)", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onRefresh() {

    }
}
