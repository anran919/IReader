package com.anakin.ireader.presenter.listener;

import java.util.List;

/**
 * 创建者     demo
 * 创建时间   2017/6/26 0026 15:57
 */

public interface OnSplashListener extends BaseOnLoadListener {
    void onSuccess(List<Integer> results);
}
