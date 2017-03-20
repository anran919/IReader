package com.anakin.ireader.model.entity;

import java.util.List;

/**
 * 创建者     demo
 * 创建时间   2016/12/19 0019 15:12
 */
public class VideoEntity {

    /**
     * error : false
     * results : [{"createdAt":"2017-03-06T09:35:43.552Z","publishedAt":"2017-03-14T13:17:14.21Z","_id":"58bcbcef421aa90f03345125","source":"chrome","used":true,"type":"休息视频","url":"http://weibo.com/tv/v/b6bc080197b7b911d442b28b3a996816?fid=1034:b6bc080197b7b911d442b28b3a996816","desc":"和珅和纪晓岚的这段对话，当初第一次看的时候，觉得和珅说了一堆，简直在放屁，如今再看，竟无法反驳。","who":"lxxself"},{"createdAt":"2017-03-13T09:28:30.339Z","publishedAt":"2017-03-13T12:37:59.782Z","_id":"58c5f5be421aa95810795c4d","source":"chrome","used":true,"type":"休息视频","url":"http://www.vmovier.com/51291","desc":"腹黑小孩疯狂报复短片《我的生涯规划》","who":"lxxself"},{"createdAt":"2017-03-06T09:40:34.326Z","publishedAt":"2017-03-10T11:43:50.30Z","_id":"58bcbe12421aa90f03345128","source":"chrome","used":true,"type":"休息视频","url":"http://sjycdn.miaopai.com/stream/KBlJAL62vKG91M5V2yNprg__.mp4?ssig=e930ad3e35820f46decd1fad8f680e60&time_stamp=1488768025919","desc":"男生碰到喜欢的人会有哪些表现？","who":"lxxself"},{"createdAt":"2017-03-08T09:25:13.170Z","publishedAt":"2017-03-09T11:42:30.849Z","_id":"58bf5d79421aa90f0334513c","source":"chrome","used":true,"type":"休息视频","url":"http://weibo.com/tv/v/EyMCcu4Z3?from=vhot","desc":"年底了决定献出我的初吻，虽然风险太大。卧槽！都是一脸懵逼，看到最后，笑死了~ [笑cry] ?","who":"lxxself"},{"createdAt":"2017-03-06T09:33:04.904Z","publishedAt":"2017-03-08T11:27:16.65Z","_id":"58bcbc50421aa90f03345124","source":"chrome","used":true,"type":"休息视频","url":"http://weibo.com/tv/v/ec295fd15cc32881c775de35debdf7c4?fid=1034:ec295fd15cc32881c775de35debdf7c4","desc":"电影狙击手:教新员工如何平复晚点乘客的心情！这演技伸手就来，厉害了的我的空姐[笑cry] ","who":"lxxself"},{"createdAt":"2017-03-06T20:03:03.939Z","publishedAt":"2017-03-07T11:52:11.670Z","_id":"58bd4ff7421aa90efc4fb67a","source":"chrome","used":true,"type":"休息视频","url":"https://www.bilibili.com/video/av8945681/","desc":"8分钟速读刘慈欣2000年银河奖科幻作品《流浪地球》","who":"jp"},{"createdAt":"2017-03-06T09:41:13.192Z","publishedAt":"2017-03-06T11:17:33.140Z","_id":"58bcbe39421aa90f13178608","source":"chrome","used":true,"type":"休息视频","url":"http://weibo.com/tv/v/0b12691b231f87ee8a7da239640321b4?fid=1034:0b12691b231f87ee8a7da239640321b4","desc":"卧槽，女朋友就这样得到了[摊手]","who":"lxxself"},{"createdAt":"2017-03-03T09:57:28.547Z","publishedAt":"2017-03-03T12:13:36.333Z","_id":"58b8cd88421aa90f03345110","source":"chrome","used":true,"type":"休息视频","url":"http://weibo.com/tv/v/da65f7217e367b4b9b55a0300bc0bd61?fid=1034:da65f7217e367b4b9b55a0300bc0bd61","desc":"真爱造就美好的事物","who":"lxxself"},{"createdAt":"2017-03-02T09:35:38.473Z","publishedAt":"2017-03-02T11:51:29.672Z","_id":"58b776ea421aa90f131785e5","source":"chrome","used":true,"type":"休息视频","url":"https://v.qq.com/x/page/c0379nxrr5h.html?start=1","desc":"神模仿《中国合伙人》，程序员撕起逼来自己都怕","who":"lxxself"},{"createdAt":"2017-02-26T09:59:28.436Z","publishedAt":"2017-03-01T12:03:57.461Z","_id":"58b23680421aa957f9dd6de0","source":"web","used":true,"type":"休息视频","url":"https://v.qq.com/x/cover/1jv433683n9m5h4/t0357ld2173.html","desc":"摩拜单车，我们都在使用，但是否想过创造？一起来听听摩拜创始人与摩拜的更多的故事吧！","who":"Codios"}]
     */
    public boolean error;
    public List<ResultsEntity> results;

    public static class ResultsEntity {
        /**
         * createdAt : 2017-03-06T09:35:43.552Z
         * publishedAt : 2017-03-14T13:17:14.21Z
         * _id : 58bcbcef421aa90f03345125
         * source : chrome
         * used : true
         * type : 休息视频
         * url : http://weibo.com/tv/v/b6bc080197b7b911d442b28b3a996816?fid=1034:b6bc080197b7b911d442b28b3a996816
         * desc : 和珅和纪晓岚的这段对话，当初第一次看的时候，觉得和珅说了一堆，简直在放屁，如今再看，竟无法反驳。
         * who : lxxself
         */
        public String createdAt;
        public String publishedAt;
        public String _id;
        public String source;
        public boolean used;
        public String type;
        public String url;
        public String desc;
        public String who;


        public String getUrl() {
            return url;
        }

        @Override
        public String toString() {
            return "ResultsEntity{" +
                    "createdAt='" + createdAt + '\'' +
                    ", publishedAt='" + publishedAt + '\'' +
                    ", _id='" + _id + '\'' +
                    ", source='" + source + '\'' +
                    ", used=" + used +
                    ", type='" + type + '\'' +
                    ", url='" + url + '\'' +
                    ", desc='" + desc + '\'' +
                    ", who='" + who + '\'' +
                    '}';
        }
    }


    public List<ResultsEntity> getResults() {
        return results;
    }

    @Override
    public String toString() {
        return "VideoEntity{" +
                "error=" + error +
                ", results=" + results +
                '}';
    }
}
