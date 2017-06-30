package com.anakin.ireader.adapter.holder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.anakin.ireader.R;
import com.anakin.ireader.helper.net.api.ZhuanLanApi;
import com.anakin.ireader.helper.utils.ZhuanLanUtil;
import com.anakin.ireader.model.entity.ArticleEntity;
import com.bumptech.glide.Glide;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 创建者     demo
 * 创建时间   2016/11/21 0021 14:41
 */
public class ArticleHolder extends BaseHolder<ArticleEntity> {
    private Context mContext;

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


    public ArticleHolder(Context context, View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mContext = context;

    }

    @Override
    public void setData(ArticleEntity data, int position) {

        String avatar_url = ZhuanLanUtil.
                getAuthorAvatarUrl(data.getAvatar().template,
                        data.getAvatar().id
                ,ZhuanLanApi.PIC_SIZE_XL);


        Glide.with(itemView.getContext())
                .load(avatar_url)
                .centerCrop()
                .placeholder(R.mipmap.picture_error_pic)
                .crossFade()
                .into(avatar);

        name.setText(data.getName());
        follower.setText(data.getFollowersCount()+"人关注");
        count.setText(data.getPostsCount()+"文");
        description.setText(data.getDescription());
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
