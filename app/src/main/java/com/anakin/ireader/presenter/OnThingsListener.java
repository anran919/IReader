package com.anakin.ireader.presenter;

import com.anakin.ireader.model.entity.ThingsEntity;

/**
 * 创建者     demo
 * 创建时间   2016/12/19 0019 15:18
 */
public interface OnThingsListener {
    void  onSuccess(ThingsEntity entity);
    void  onFail();
}
