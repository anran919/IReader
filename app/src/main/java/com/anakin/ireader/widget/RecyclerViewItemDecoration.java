package com.anakin.ireader.widget;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * 创建者     demo
 * 创建时间   2016/11/24 0024 10:39
 */
public class RecyclerViewItemDecoration extends RecyclerView.ItemDecoration {
    private int h;
    private int v;


    public RecyclerViewItemDecoration(int h, int v) {
        this.h = h;
        this.v=v;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {

        if (parent.getChildPosition(view) != 0)
            outRect.top = v;
        outRect.bottom = v;
        outRect.left = h;
        outRect.right = h;
    }

}
