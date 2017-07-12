package com.anakin.ireader.model.entity;

import java.util.List;

/**
 * 创建者     demo
 * 创建时间   2017/7/5 0005 14:45
 */
public class ArticleBean {

    /**
     * acceptSubmission : true
     * activateAuthorRequested : none
     * activateState : activated
     * avatar : {"id":"5a1ec50171767c4fc856f430e46297db","template":"https://pic4.zhimg.com/{id}_{size}.jpg"}
     * banUntil : 0
     * canManage : false
     * canPost : false
     * commentPermission : anyone
     * creator : {"avatar":{"id":"34bf96bf5584ac4b5264bd7ed4fdbc5a","template":"https://pic3.zhimg.com/{id}_{size}.jpg"},"bio":"欢迎反馈问题和建议！","description":"","hash":"3d198a56310c02c4a83efb9f4a4c027e","isOrg":false,"isOrgWhiteList":false,"name":"知乎小管家","profileUrl":"https://www.zhihu.com/people/zhihuadmin","slug":"zhihuadmin","uid":53253479858176}
     * description : 知乎社区管理团队官方专栏，不定期更新社区管理工作相关的最新消息。
     * firstTime : false
     * followersCount : 9985
     * following : false
     * href : /api/columns/zhihuadmin
     * intro : 知乎社区管理团队官方专栏，不定期更新社区管理工作…
     * name : 知乎小管家说
     * nameCanEditUntil : 0
     * pendingName :
     * pendingTopics : []
     * postTopics : [{"id":2,"name":"知乎","postsCount":26},{"id":6,"name":"知乎指南","postsCount":1},{"id":96,"name":"知乎产品改进","postsCount":1},{"id":176,"name":"腾讯","postsCount":1},{"id":220,"name":"知乎社区","postsCount":32},{"id":413,"name":"百度","postsCount":1},{"id":439,"name":"知乎用户","postsCount":6},{"id":630,"name":"知乎产品","postsCount":3},{"id":15068,"name":"知乎提问","postsCount":1},{"id":21005,"name":"回答折叠（知乎功能）","postsCount":1},{"id":24147,"name":"知乎规范","postsCount":1},{"id":153456,"name":"知乎社区管理条例","postsCount":1},{"id":165207,"name":"知乎安全中心","postsCount":2}]
     * postsCount : 48
     * reason :
     * slug : zhihuadmin
     * topics : [{"id":"19552112","name":"知乎建议反馈","url":"https://www.zhihu.com/topic/19552112"},{"id":"19550887","name":"知乎社区","url":"https://www.zhihu.com/topic/19550887"},{"id":"19550228","name":"知乎","url":"https://www.zhihu.com/topic/19550228"}]
     * topicsCanEditUntil : 0
     * url : /zhihuadmin
     */

    public boolean acceptSubmission;
    public String activateAuthorRequested;
    public String activateState;
    public AvatarEntity avatar;
    public int banUntil;
    public boolean canManage;
    public boolean canPost;
    public String commentPermission;
    public CreatorEntity creator;
    public String description;
    public boolean firstTime;
    public int followersCount;
    public boolean following;
    public String href;
    public String intro;
    public String name;
    public int nameCanEditUntil;
    public String pendingName;
    public int postsCount;
    public String reason;
    public String slug;
    public int topicsCanEditUntil;
    public String url;
    public List<?> pendingTopics;
    public List<PostTopicsEntity> postTopics;
    public List<TopicsEntity> topics;

    public static class AvatarEntity {
        /**
         * id : 5a1ec50171767c4fc856f430e46297db
         * template : https://pic4.zhimg.com/{id}_{size}.jpg
         */

        public String id;
        public String template;

        public String getId() {
            return id;
        }

        public String getTemplate() {
            return template;
        }
    }

    public static class CreatorEntity {
        /**
         * avatar : {"id":"34bf96bf5584ac4b5264bd7ed4fdbc5a","template":"https://pic3.zhimg.com/{id}_{size}.jpg"}
         * bio : 欢迎反馈问题和建议！
         * description :
         * hash : 3d198a56310c02c4a83efb9f4a4c027e
         * isOrg : false
         * isOrgWhiteList : false
         * name : 知乎小管家
         * profileUrl : https://www.zhihu.com/people/zhihuadmin
         * slug : zhihuadmin
         * uid : 53253479858176
         */

        public AvatarEntityX avatar;
        public String bio;
        public String description;
        public String hash;
        public boolean isOrg;
        public boolean isOrgWhiteList;
        public String name;
        public String profileUrl;
        public String slug;
        public long uid;

        public static class AvatarEntityX {
            /**
             * id : 34bf96bf5584ac4b5264bd7ed4fdbc5a
             * template : https://pic3.zhimg.com/{id}_{size}.jpg
             */

            public String id;
            public String template;
        }
    }

    public static class PostTopicsEntity {
        /**
         * id : 2
         * name : 知乎
         * postsCount : 26
         */

        public int id;
        public String name;
        public int postsCount;
    }

    public static class TopicsEntity {
        /**
         * id : 19552112
         * name : 知乎建议反馈
         * url : https://www.zhihu.com/topic/19552112
         */

        public String id;
        public String name;
        public String url;
    }

    @Override
    public String toString() {
        return "ArticleBean{" +
                "acceptSubmission=" + acceptSubmission +
                ", activateAuthorRequested='" + activateAuthorRequested + '\'' +
                ", activateState='" + activateState + '\'' +
                ", avatar=" + avatar +
                ", banUntil=" + banUntil +
                ", canManage=" + canManage +
                ", canPost=" + canPost +
                ", commentPermission='" + commentPermission + '\'' +
                ", creator=" + creator +
                ", description='" + description + '\'' +
                ", firstTime=" + firstTime +
                ", followersCount=" + followersCount +
                ", following=" + following +
                ", href='" + href + '\'' +
                ", intro='" + intro + '\'' +
                ", name='" + name + '\'' +
                ", nameCanEditUntil=" + nameCanEditUntil +
                ", pendingName='" + pendingName + '\'' +
                ", postsCount=" + postsCount +
                ", reason='" + reason + '\'' +
                ", slug='" + slug + '\'' +
                ", topicsCanEditUntil=" + topicsCanEditUntil +
                ", url='" + url + '\'' +
                ", pendingTopics=" + pendingTopics +
                ", postTopics=" + postTopics +
                ", topics=" + topics +
                '}';
    }


    public String getActivateAuthorRequested() {
        return activateAuthorRequested;
    }

    public String getActivateState() {
        return activateState;
    }

    public AvatarEntity getAvatar() {
        return avatar;
    }

    public int getBanUntil() {
        return banUntil;
    }

    public boolean isCanManage() {
        return canManage;
    }

    public boolean isCanPost() {
        return canPost;
    }

    public String getCommentPermission() {
        return commentPermission;
    }

    public CreatorEntity getCreator() {
        return creator;
    }

    public String getDescription() {
        return description;
    }

    public boolean isFirstTime() {
        return firstTime;
    }

    public int getFollowersCount() {
        return followersCount;
    }

    public boolean isFollowing() {
        return following;
    }

    public String getHref() {
        return href;
    }

    public String getIntro() {
        return intro;
    }

    public String getName() {
        return name;
    }

    public int getNameCanEditUntil() {
        return nameCanEditUntil;
    }

    public String getPendingName() {
        return pendingName;
    }

    public int getPostsCount() {
        return postsCount;
    }

    public String getReason() {
        return reason;
    }

    public String getSlug() {
        return slug;
    }

    public int getTopicsCanEditUntil() {
        return topicsCanEditUntil;
    }

    public String getUrl() {
        return url;
    }

    public List<?> getPendingTopics() {
        return pendingTopics;
    }

    public List<PostTopicsEntity> getPostTopics() {
        return postTopics;
    }

    public List<TopicsEntity> getTopics() {
        return topics;
    }

    public boolean isAcceptSubmission() {
        return acceptSubmission;
    }
}
