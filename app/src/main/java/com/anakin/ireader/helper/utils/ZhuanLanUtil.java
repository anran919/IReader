package com.anakin.ireader.helper.utils;

import com.anakin.ireader.helper.net.api.ZhuanLanApi;

/**
 * 创建者     demo
 * 创建时间   2017/6/30 0030 17:20
 */
public class ZhuanLanUtil {

    public static String getAuthorAvatarUrl(String origin, String userId, String size) {
        origin = origin.replace(ZhuanLanApi.TEMPLATE_ID, userId);
        return origin.replace(ZhuanLanApi.TEMPLATE_SIZE, size);
    }
}
