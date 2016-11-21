package com.anakin.ireader.adapter.holder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.anakin.ireader.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 创建者     demo
 * 创建时间   2016/11/21 0021 14:41
 */
public class ArticelHolder extends BaseHolder<String> {
    @Bind(R.id.tv_title)
    TextView mTitle;
    @Bind(R.id.tv_date)
    TextView mdate;
    @Bind(R.id.tv_content)
    TextView mContent;
    @Bind(R.id.img)
    public ImageView img;
    private View item;
    private Context mContext;

    public ArticelHolder(Context context, View itemView) {
        super(itemView);
        item = itemView;
        mContext = context;
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void setData(String data) {
        mTitle.setText(data);
        img.setImageResource(R.mipmap.ic_launcher);
//        mdate.setText(item.getDate());
//        mContent.setText(item.getContent());
//        mItem = item;
//        if (item.getType()==ListItem.PICTURE||item.getType()==ListItem.THING)
//        {
//            Picasso.with(itemView.getContext()).load(item.getImg()).fit().into(img);
//        }else
//        {
//            img.setBackgroundResource(R.drawable.smile);
//        }
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        Toast.makeText(mContext, "setClickListener ------>", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onLongClick(View view) {
        Toast.makeText(mContext, "onLongClick ------>", Toast.LENGTH_SHORT).show();
        return super.onLongClick(view);

    }


}
