package com.anakin.ireader.ui.fragment;

import android.app.ProgressDialog;
import android.graphics.Color;
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
import com.anakin.ireader.adapter.MoviesAdapter;
import com.anakin.ireader.model.entity.MovieEntity;
import com.anakin.ireader.presenter.impl.MoviesPresenterImpl;
import com.anakin.ireader.ui.view.MoviesView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 创建者     demo
 * 创建时间   2016/11/21 0021 14:43
 */
public class MoviesFragment extends BaseFragment implements MoviesView, View.OnClickListener, SwipeRefreshLayout.OnRefreshListener {

    private static final MoviesFragment QUESTIONS_FRAGMENT = new MoviesFragment();
    private static final String TAG = "MoviesFragment";
    @Bind(R.id.recyclerview_articel)
    RecyclerView mRecyclerView;
    @Bind(R.id.swrfresh)
    SwipeRefreshLayout mSwrfresh;
    private ProgressDialog mProgressDialog;
    private MoviesPresenterImpl mMoviesPresenter;
    private boolean isRefresh;
    private MoviesAdapter mMovicesAdapter;
    private List<MovieEntity.SubjectsEntity> mSubjects;
    private LinearLayoutManager mManager;

    private MoviesFragment() {
    }

    @Override
    public View inflaterView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fregment_article, container, false);
        ButterKnife.bind(this, rootView);
        initView();
        return rootView;
    }

    private void initView() {
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

        mMoviesPresenter = new MoviesPresenterImpl(this);  // 将View传递到Presenter
        mProgressDialog = new ProgressDialog(mContext);
        mProgressDialog.setTitle("正在查询数据......");

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mMoviesPresenter.getMovies(0, 50); // 将输入的内容传递到presnter
    }

    public static MoviesFragment getInstance() {
        return QUESTIONS_FRAGMENT;
    }

    @Override
    public void setMoviesInfo(MovieEntity movieEntity) {
        // 设置数据
        mSubjects = movieEntity.getSubjects();
        mMovicesAdapter = new MoviesAdapter(mContext, mSubjects, R.layout.item_movices_us);
        mManager = new LinearLayoutManager(mContext);
        mRecyclerView.setLayoutManager(mManager);
        mRecyclerView.setAdapter(mMovicesAdapter);
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onRefresh() {
//        //检查是否处于刷新状态
//        if (!isRefresh) {
//            isRefresh = true;
//            //模拟加载网络数据，这里设置4秒，正好能看到4色进度条
//            new Handler().postDelayed(new Runnable() {
//                public void run() {
//                    //显示或隐藏刷新进度条
//                    mSwrfresh.setRefreshing(false);
//                    //修改adapter的数据
////                    mSubjects.add("这是新添加的数据");
//                    mMovicesAdapter.notifyDataSetChanged();
//                    isRefresh = false;
//                }
//            }, 4000);
//        }

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
    public void showErrorMsg(String msg) {
        Toast.makeText(mContext, "加载数据失败", Toast.LENGTH_SHORT).show();
    }
}
