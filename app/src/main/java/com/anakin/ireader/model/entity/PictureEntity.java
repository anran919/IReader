package com.anakin.ireader.model.entity;

import java.util.List;

/**
 * 创建者     demo
 * 创建时间   2016/11/23 0023 15:22
 */
public class PictureEntity {


    public List<ResultsEntity> getResults() {
        return results;
    }

    /**
     * error : false
     * results : [{"_id":"58350b5e421aa972148296ed","createdAt":"2016-11-23T11:22:06.516Z","desc":"11-23","publishedAt":"2016-11-23T11:27:52.847Z","source":"chrome","type":"福利","url":"http://ww1.sinaimg.cn/large/610dc034gw1fa1vkn6nerj20u011gdjm.jpg","used":true,"who":"代码家"},{"_id":"5833b7f1421aa926e26ae819","createdAt":"2016-11-22T11:13:53.663Z","desc":"11-22","publishedAt":"2016-11-22T11:30:13.971Z","source":"chrome","type":"福利","url":"http://ww4.sinaimg.cn/large/610dc034gw1fa0ppsw0a7j20u00u0thp.jpg","used":true,"who":"daimajia"},{"_id":"58326224421aa929ac960b05","createdAt":"2016-11-21T10:55:32.265Z","desc":"11-21","publishedAt":"2016-11-21T11:16:48.599Z","source":"chrome","type":"福利","url":"http://ww2.sinaimg.cn/large/610dc034gw1f9zjk8iaz2j20u011hgsc.jpg","used":true,"who":"代码家"},{"_id":"582e4c38421aa94ffa9f7641","createdAt":"2016-11-18T08:32:56.22Z","desc":"AB","publishedAt":"2016-11-18T11:21:35.425Z","source":"chrome","type":"福利","url":"http://ww2.sinaimg.cn/large/610dc034jw1f9vyl2fqi0j20u011habc.jpg","used":true,"who":"daimajia "},{"_id":"582cf408421aa95002741a8f","createdAt":"2016-11-17T08:04:24.781Z","desc":"11-17","publishedAt":"2016-11-17T11:32:04.807Z","source":"chrome","type":"福利","url":"http://ww2.sinaimg.cn/large/610dc034jw1f9us52puzsj20u00u0jtd.jpg","used":true,"who":"daimajia "},{"_id":"582ba25b421aa93a5939d4bc","createdAt":"2016-11-16T08:03:39.788Z","desc":"11-16","publishedAt":"2016-11-16T11:37:18.947Z","source":"chrome","type":"福利","url":"http://ww3.sinaimg.cn/large/610dc034jw1f9tmhxq87lj20u011htae.jpg","used":true,"who":"daimajia"},{"_id":"582a56cb421aa9102c2ec6e7","createdAt":"2016-11-15T08:28:59.621Z","desc":"11-15","publishedAt":"2016-11-15T11:26:11.821Z","source":"chrome","type":"福利","url":"http://ww3.sinaimg.cn/large/610dc034gw1f9shm1cajkj20u00jy408.jpg","used":true,"who":"daimajia"},{"_id":"58290634421aa911cf2e155c","createdAt":"2016-11-14T08:32:52.84Z","desc":"11-14","publishedAt":"2016-11-14T11:36:49.680Z","source":"chrome","type":"福利","url":"http://ww3.sinaimg.cn/large/610dc034jw1f9rc3qcfm1j20u011hmyk.jpg","used":true,"who":"daimajia"},{"_id":"58250c1d421aa90e799ec2bf","createdAt":"2016-11-11T08:09:01.465Z","desc":"11-11","publishedAt":"2016-11-11T12:03:10.196Z","source":"chrome","type":"福利","url":"http://ww3.sinaimg.cn/large/610dc034jw1f9nuk0nvrdj20u011haci.jpg","used":true,"who":"daimajia"},{"_id":"5823bc03421aa91369f95a1d","createdAt":"2016-11-10T08:14:59.395Z","desc":"11-10","publishedAt":"2016-11-10T11:40:42.4Z","source":"chrome","type":"福利","url":"http://ww4.sinaimg.cn/large/610dc034jw1f9mp3xhjdhj20u00u0ta9.jpg","used":true,"who":"daimajia"}]
     */

    public boolean error;

    private List<ResultsEntity> results;

    /**
     * _id : 58350b5e421aa972148296ed
     * createdAt : 2016-11-23T11:22:06.516Z
     * desc : 11-23
     * publishedAt : 2016-11-23T11:27:52.847Z
     * source : chrome
     * type : 福利
     * url : http://ww1.sinaimg.cn/large/610dc034gw1fa1vkn6nerj20u011gdjm.jpg
     * used : true
     * who : 代码家
     */

    public static class ResultsEntity {

        public String get_id() {
            return _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public String getSource() {
            return source;
        }

        public String getType() {
            return type;
        }

        public String getUrl() {
            return url;
        }

        public boolean isUsed() {
            return used;
        }

        public String getWho() {
            return who;
        }

        public String _id;
        public String createdAt;
        public String desc;
        public String publishedAt;
        public String source;
        public String type;
        private String url;
        public boolean used;
        public String who;

        @Override
        public String toString() {
            return "ResultsEntity{" +
                    "_id='" + _id + '\'' +
                    ", createdAt='" + createdAt + '\'' +
                    ", desc='" + desc + '\'' +
                    ", publishedAt='" + publishedAt + '\'' +
                    ", source='" + source + '\'' +
                    ", type='" + type + '\'' +
                    ", url='" + url + '\'' +
                    ", used=" + used +
                    ", who='" + who + '\'' +
                    '}';
        }
    }
}
