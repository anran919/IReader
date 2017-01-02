package com.anakin.ireader.ui.view;

import com.anakin.ireader.model.entity.ListItem;
import java.util.List;

/**
 * 创建者     demo
 * 创建时间   2016/11/21 0021 18:05
 */
public interface ArticleView {
    void showDatas(List<ListItem> dailies);

    void showProgress();

    void hideProgress();

    void showMsg(String msg);
}