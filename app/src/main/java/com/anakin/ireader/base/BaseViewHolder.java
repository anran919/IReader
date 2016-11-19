package com.anakin.ireader.base;

import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;

import com.anakin.ireader.interf.OnItemClickListener;
import com.anakin.ireader.interf.OnItemLongClickListener;

/**
 * 创建者     demo
 * 创建时间   2016/11/19 0019 18:12
 */
public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder implements View.OnLongClickListener, View.OnClickListener {

    SparseArray<View> mView;

    public BaseViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
    }

    public abstract <T> void setData(T data);

    @Override
    public boolean onLongClick(View view) {
        if (mItemLongClickListener != null) {
            mItemLongClickListener.itemLongClick(view, getLayoutPosition());
        }
        return false;
    }

    @Override
    public void onClick(View view) {
        if (mItemClickListener != null) {
            mItemClickListener.itemClick(view, getLayoutPosition());
        }
    }

    OnItemClickListener mItemClickListener;
    OnItemLongClickListener mItemLongClickListener;

    public void setItemClickListener(OnItemClickListener listener) {
        mItemClickListener = listener;
    }

    public void setItemLongClickListener(OnItemLongClickListener listener) {
        mItemLongClickListener = listener;
    }


    public void setTextView(@IdRes int id, String text) {
        TextView view = findView(id);
        view.setText(text);
    }

    public <Tv> Tv findView(@IdRes int id) {
        View view = mView.get(id);
        if (view != null)
            view = itemView.findViewById(id);
        return (Tv) view;
    }

}
