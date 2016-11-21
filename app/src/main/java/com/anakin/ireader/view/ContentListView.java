package com.anakin.ireader.view;

import com.anakin.ireader.bean.ListItem;

import java.util.List;

/**
 * 创建者     demo
 * 创建时间   2016/11/21 0021 18:05
 */
public interface ContentListView {

    void showDatas(List<ListItem> dailies);

    void showProgress();

    void hideProgress();

    void showMsg(String msg);
}
