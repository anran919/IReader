package com.anakin.ireader.helper.net.api;

/**
 * 创建者     demo
 * 创建时间   2017/6/28 0028 10:28
 */
public class GankApi {
    public interface Picture{
        //    http://gank.io/api/data/福利/10/1
       String BASE_URL = "http://gank.io/api/data/福利/";
    }
    public interface Video{
        // http://gank.io/api/data/休息视频/10/1
        String BASE_URL = "http://gank.io/api/data/休息视频/";
    }
}
