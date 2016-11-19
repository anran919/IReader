package com.anakin.ireader.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anakin.ireader.base.BaseViewHolder;

import java.util.List;

/**
 * 创建者     demo
 * 创建时间   2016/11/19 0019 18:11
 */
public abstract class BaseAdapter<T> extends RecyclerView.Adapter<BaseViewHolder<T>> {

    private List<T> datas;
    private Context mContext;
    private int res_id;

    //List<T> datas, Context context, int res_id
    public BaseAdapter(List<T> datas, Context context, int res_id) {
        this.datas = datas;
        this.mContext = context;
        this.res_id = res_id;
    }

    public BaseAdapter() {

    }

    @Override
    public BaseViewHolder<T> onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(res_id, parent, false);
        return createHolder(view);
    }

    protected abstract BaseViewHolder<T> createHolder(View view);

    @Override
    public int getItemCount() {
        return datas.size();
    }

    @Override
    public void onBindViewHolder(BaseViewHolder<T> holder, int position) {
        T item = datas.get(position);
        holder.setData(item);
    }
}
