package com.anakin.ireader.helper.utils;

import android.content.Context;
import android.content.Intent;

import com.anakin.ireader.ui.activity.ZhuanLanListActivity;

/**
 * 创建者     demo
 * 创建时间   2017/7/10 0010 11:19
 */
public class AppUtil {


    public static void startActivty(Context context, Class<ZhuanLanListActivity> zhuanLanListActivityClass) {

        context.startActivity(new Intent(context,zhuanLanListActivityClass));
    }
}
