package com.anakin.ireader.model.entity;

/**
 * 创建者     demo
 * 创建时间   2016/12/19 0019 15:12
 */
public class VideoEntity {

    String video_url;

    public String getVideo_url() {
        return video_url;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }

    @Override
    public String toString() {
        return "VideoEntity{" +
                "video_url='" + video_url + '\'' +
                '}';
    }
}
