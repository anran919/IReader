package com.anakin.ireader.adapter.holder;

import android.content.Context;
import android.view.View;

import com.anakin.ireader.model.entity.ListItem;

import butterknife.ButterKnife;

/**
 * 创建者     demo
 * 创建时间   2016/11/21 0021 14:41
 */
public class ArticleHolder extends BaseHolder<ListItem> {
    private Context mContext;

//    @Bind(R.id.tv_title)
//    TextView mTitle;
//    @Bind(R.id.tv_date)
//    TextView mDate;
//    @Bind(R.id.tv_content)
//    TextView mContent;
//    @Bind(R.id.img)
//    ImageView img;


    public ArticleHolder(Context context, View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mContext = context;

    }

    @Override
    public void setData(ListItem data, int position) {
//        mTitle.setText(data.toString());

//        Glide.with(itemView.getContext())
//                .load(R.mipmap.picture_error_pic)
//                .centerCrop()
//                .placeholder(R.mipmap.picture_error_pic)
//                .crossFade()
//                .into(img);
//        mContent.setText("黄粱一梦二十年，依旧是不懂情也不懂爱，听歌的人最无情，写歌的人假正经");
//        mDate.setText("2016年11月22日 11:39:41");

    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
    }

    @Override
    public boolean onLongClick(View view) {
        return super.onLongClick(view);

    }


}
