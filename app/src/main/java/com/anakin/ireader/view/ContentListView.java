package com.anakin.ireader.view;

import com.anakin.ireader.bean.ListItem;

import java.util.List;

/**
 * 创建者     demo
 * 创建时间   2016/11/19 0019 18:01
 */

public interface ContentListView {
    void showDatas(List<ListItem> dailies);

    void showProgress();

    void hideProgress();

    void showMsg(String msg);
}
