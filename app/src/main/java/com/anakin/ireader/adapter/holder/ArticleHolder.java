package com.anakin.ireader.adapter.holder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.anakin.ireader.R;
import com.anakin.ireader.helper.net.api.ZhuanLanApi;
import com.anakin.ireader.helper.utils.AppUtil;
import com.anakin.ireader.helper.utils.ZhuanLanUtil;
import com.anakin.ireader.model.entity.ArticleEntity;
import com.anakin.ireader.ui.activity.ZhuanLanListActivity;
import com.anakin.ireader.widget.GlideCircleTransform;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 创建者     demo
 * 创建时间   2016/11/21 0021 14:41
 */
public class ArticleHolder extends BaseHolder<ArticleEntity> {

    @Bind(R.id.avatar)
    ImageView avatar;  // 图
    @Bind(R.id.tv_name)
    TextView name;
    @Bind(R.id.tv_follower)
    TextView follower; // 关注
    @Bind(R.id.tv_separator)
    TextView separator;
    @Bind(R.id.tv_post_count)
    TextView count;  //
    @Bind(R.id.tv_description)
    TextView description;  //描述

    private  List<ArticleEntity> mDatas;
    private Context mContext;

    public ArticleHolder(Context context, List<ArticleEntity> datas, View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.mContext =context;
        this.mDatas= datas;

    }

    @Override
    public void setData(ArticleEntity data, int position) {
        if (data == null) {
            return;
        }
        String avatar_url = ZhuanLanUtil.
                getAuthorAvatarUrl(data.getAvatar_template(),
                        data.getAvatar_id()+""
                        , ZhuanLanApi.PIC_SIZE_XL);


        Glide
                .with(itemView.getContext())
                .load(avatar_url)
//                .error(R.mipmap.pic062)
//                .animate(animationObject) // 使用自定义的动画
                .transform(new GlideCircleTransform(itemView.getContext())) // 转换成圆形图片
//                .transform(new GlideRoundTransform(this,20))   // 转换成圆角图片
                .into(avatar);


        name.setText(data.getName());
        follower.setText(data.getFollowersCount() + "人关注");
        count.setText(data.getPostsCount() + "文");
        description.setText(data.getDescription());

    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        // 点击了item 进入详情页面
        new ZhuanLanListActivity().transmit(mDatas.get(getAdapterPosition()));
        AppUtil.startActivty(mContext,ZhuanLanListActivity.class);

    }
}
