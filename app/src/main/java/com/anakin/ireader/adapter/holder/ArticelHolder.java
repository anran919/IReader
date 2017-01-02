package com.anakin.ireader.adapter.holder;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.anakin.ireader.R;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 创建者     demo
 * 创建时间   2016/11/21 0021 14:41
 */
public class ArticelHolder extends BaseHolder<String> {
    private static final String TAG = "ArticelHolder";
    private Context mContext;

    @Bind(R.id.tv_title)
    TextView mTitle;
    @Bind(R.id.tv_date)
    TextView mDate;
    @Bind(R.id.tv_content)
    TextView mContent;
    @Bind(R.id.img)
    ImageView img;

//    TextView mTitle;
//    TextView mDate;
//    TextView mContent;
//    ImageView img;

    public ArticelHolder(Context context, View itemView) {
        super(itemView);
//        this.mItemView = itemView;
        Log.e(TAG," ====== ARTICLE HOLDER ==========="+itemView);
        ButterKnife.bind(this, itemView);
        mContext = context;
//        mTitle=  getView(R.id.tv_title);
//        mDate= getView(R.id.tv_date);
//        mContent=getView(R.id.tv_content);
//        img=getView(R.id.img);

    }

    @Override
    public void setData(String data) {
        mTitle.setText(data);
        Picasso.with(itemView.getContext()).load(R.mipmap.picture_error_pic).fit().into(img);
        mContent.setText("黄粱一梦二十年，依旧是不懂情也不懂爱，听歌的人最无情，写歌的人假正经");
        mDate.setText("2016年11月22日 11:39:41");
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
