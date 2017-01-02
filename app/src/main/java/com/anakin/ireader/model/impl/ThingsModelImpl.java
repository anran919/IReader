package com.anakin.ireader.model.impl;

import com.anakin.ireader.model.entity.ThingsEntity;
import com.anakin.ireader.model.entity.ThingsModel;
import com.anakin.ireader.presenter.impl.ThingsPresenterImpl;

/**
 * 创建者     demo
 * 创建时间   2016/12/19 0019 15:25
 */
public class ThingsModelImpl implements ThingsModel {
    /**
     * 加载数据
     *
     * @param thingsPresenter
     */
    @Override
    public void getThings(ThingsPresenterImpl thingsPresenter) {
        ThingsEntity entity = new ThingsEntity();
//        加载结果
        Boolean isSuccess = false;
        if (isSuccess) {
            thingsPresenter.onSuccess(entity);
        } else {
            thingsPresenter.onFail();
        }
    }
}
