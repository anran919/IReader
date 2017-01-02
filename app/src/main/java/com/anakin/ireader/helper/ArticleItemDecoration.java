package com.anakin.ireader.helper;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by demo on 2017/1/2 0002
 * <p/>
 * 设置article 页面的item间距
 */
public class ArticleItemDecoration extends RecyclerView.ItemDecoration {

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.set(5, 5, 5, 5);
    }
}
