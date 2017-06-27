package com.anakin.ireader.adapter.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.anakin.ireader.listener.OnItemClickListener;
import com.anakin.ireader.listener.OnItemLongClickListener;

/**
 * 创建者     demo
 * 创建时间   2016/11/21 0021 11:42
 * 提供抽象方法，子类设置具体的数据
 * 设置item的事件监听
 */
public abstract class BaseHolder<T> extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
    private static final String TAG = "BaseHolder";
    OnItemLongClickListener mLongClickListener;
    OnItemClickListener mClickListener;
    public View itemView;

    public BaseHolder(View itemView) {
        super(itemView);
        this.itemView=itemView;
        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);


    }

    public abstract void setData(T data, int position);

    public void setLongClickListener(OnItemLongClickListener listener) {
        mLongClickListener = listener;
    }

    public void setClickListener(OnItemClickListener listener) {
        mClickListener = listener;
    }


    @Override
    public void onClick(View view) {
        if (mClickListener != null) {
            mClickListener.onItemClick(view,getLayoutPosition());
        }
    }

    @Override
    public boolean onLongClick(View view) {
        if (mLongClickListener != null) {
            mLongClickListener.onItemLongClick(view,getLayoutPosition());
        }
        return true;
    }


}
