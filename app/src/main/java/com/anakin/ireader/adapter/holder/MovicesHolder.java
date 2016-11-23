package com.anakin.ireader.adapter.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.anakin.ireader.R;
import com.anakin.ireader.model.entity.MovieEntity;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 创建者     demo
 * 创建时间   2016/11/22 0022 19:16
 */
public class MovicesHolder extends BaseHolder<MovieEntity.SubjectsEntity> {
    @Bind(R.id.tv_rank)
    TextView renk;
    @Bind(R.id.iv_film_photo)
    ImageView photo;
    @Bind(R.id.tv_film_title)
    TextView title;
    @Bind(R.id.tv_film_english_title)
    TextView enTitle;
    @Bind(R.id.tv_film_grade)
    TextView grade;

    public MovicesHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void setData(MovieEntity.SubjectsEntity data) {
        title.setText(data.title);
        String small = data.images.getSmall();
        Picasso.with(itemView.getContext()).load(small).fit().into(photo);
        grade.setText("评分："+data.rating.average);
        enTitle.setText(data.original_title);
    }
}
