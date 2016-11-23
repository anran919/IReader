package com.anakin.ireader.adapter;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anakin.ireader.adapter.holder.BaseHolder;

import java.util.List;

/**
 * 创建者     demo
 * 创建时间   2016/11/21 0021 11:39
 */
public abstract class BaseAdapter<T> extends RecyclerView.Adapter<BaseHolder<T>> {

    private static final String TAG = "BaseAdapter";
    private List<T> datas;
    private int res_id;
    public Context mContext;

    public BaseAdapter(Context context,  List<T> datas, int res_id) {
        mContext = context;
        this.datas = datas;
        this.res_id = res_id;
    }


    @Override
    public BaseHolder<T> onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(res_id, parent, false);
        return createHolder(mContext,view);
    }

    public abstract BaseHolder<T> createHolder(Context context, View view);

    @Override
    public void onBindViewHolder(BaseHolder<T> holder, int position) {
        T t = datas.get(position);
        holder.setData(t);
    }


    @Override
    public int getItemCount() {
        return datas.size();
    }
}
