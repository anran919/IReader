package com.anakin.ireader.presenter;

import com.anakin.ireader.view.ContentListView;

/**
 * 创建者     demo
 * 创建时间   2016/11/21 0021 18:04
 */
public interface ListPresenter {
    /** 加载第Page页
     */
    void loadListDates();
    void loadMore();
    void attachView(ContentListView view);
    void detach();
    void onResume();
}
