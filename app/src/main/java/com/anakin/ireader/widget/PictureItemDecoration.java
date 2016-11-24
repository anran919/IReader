package com.anakin.ireader.widget;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * 创建者     demo
 * 创建时间   2016/11/24 0024 10:39
 */
public class PictureItemDecoration extends RecyclerView.ItemDecoration {
    private int space;

    public PictureItemDecoration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {

        if (parent.getChildPosition(view) != 0)
            outRect.top = space;
        outRect.bottom = space;
        outRect.left = space;
        outRect.right = space;
    }

}
