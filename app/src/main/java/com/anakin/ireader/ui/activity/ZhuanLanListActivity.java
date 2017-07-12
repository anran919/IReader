package com.anakin.ireader.ui.activity;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.anakin.ireader.R;
import com.anakin.ireader.helper.utils.L;
import com.anakin.ireader.model.entity.ArticleEntity;
import com.anakin.ireader.presenter.IZhuanLanListPresenter;
import com.anakin.ireader.presenter.impl.ZhuanLanListPresenter;
import com.anakin.ireader.ui.view.IZhuanLanListView;

import butterknife.Bind;

/**
 * 创建者     demo
 * 创建时间   2017/7/10 0010 10:36
 */
public class ZhuanLanListActivity extends BaseActivity implements IZhuanLanListView {
    @Bind(R.id.tv_name)
    TextView mTvName;
    @Bind(R.id.tv_bio)
    TextView mTvBio;
    @Bind(R.id.iv_avatar)
    ImageView mIvAvatar;
    @Bind(R.id.tv_description)
    TextView mTvDescription;
    @Bind(R.id.head_layout)
    LinearLayout mHeadLayout;
    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.collapsing_toolbar)
    CollapsingToolbarLayout mCollapsingToolbar;
    @Bind(R.id.app_bar)
    AppBarLayout mAppBar;
    @Bind(R.id.recycler_view)
    RecyclerView mRecyclerView;
    private static IZhuanLanListPresenter presenter;
    private ArticleEntity mEntity;

    @Override
    public int getLayoutId() {
        return R.layout.act_zhuanlan_list;
    }

    @Override
    protected void initView() {
//        new ArticleListAdapter();
    }


    /**
     * article 中传递的作者文章列表
     * @param entity
     */
    public void transmit(ArticleEntity entity) {
        L.d(" show article entity %s",entity.toString());
        this.mEntity = entity;
        // 使用mvp
        presenter = new ZhuanLanListPresenter();
        presenter.attach(this);
        presenter.requestPostList(entity,0); //请求第一页

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showErrorMsg(String msg) {

    }
}
