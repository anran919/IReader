package com.anakin.ireader.model.entity;

import java.util.List;

/**
 * 创建者     demo
 * 创建时间   2016/11/25 0025 18:55
 */
public class ArticleEntity {

    /**
     * followersCount : 30212
     * creator : {"profileUrl":"https://www.zhihu.com/people/qin.chao","bio":"曾经沧海难为水的Facebook早期员工","hash":"7407795460968de9aa7f60d890b29c39","uid":26820170743808,"isOrg":false,"description":"北美FLAG找工作攻略，硅谷前沿，计算机牛校申请心得、大学经验和职业发展道路建议（计算机）。\n*平时尽量挤时间知乎答题，专栏会保持更新，有问题想问我的，请前往：\n(1)「值乎」提问（https://www.zhihu.com/zhi/people/723683409859219456）。\n(2) 微信公众号：qc_empire\n- 本人已委托维权骑士（http://rightknights.com）为我的文章进行维权行动。","isOrgWhiteList":false,"slug":"qin.chao","avatar":{"id":"d377edfcb","template":"https://pic4.zhimg.com/{id}_{size}.jpg"},"name":"覃超"}
     * topics : [{"url":"https://www.zhihu.com/topic/19550560","id":"19550560","name":"创业"},{"url":"https://www.zhihu.com/topic/19550340","id":"19550340","name":"Facebook"},{"url":"https://www.zhihu.com/topic/19552330","id":"19552330","name":"程序员"}]
     * activateState : activated
     * href : /api/columns/qinchao
     * acceptSubmission : true
     * firstTime : false
     * postTopics : [{"postsCount":1,"id":5,"name":"创业公司"},{"postsCount":1,"id":9,"name":"企业文化"},{"postsCount":1,"id":11,"name":"史蒂夫·乔布斯（Steve Jobs）"},{"postsCount":3,"id":15,"name":"MacBook Pro"},{"postsCount":1,"id":17,"name":"Mac"},{"postsCount":7,"id":40,"name":"Facebook"},{"postsCount":7,"id":41,"name":"马克·扎克伯格（Mark Zuckerberg）"},{"postsCount":1,"id":49,"name":"互联网创业公司"},{"postsCount":9,"id":54,"name":"硅谷"},{"postsCount":1,"id":66,"name":"风险投资（VC）"},{"postsCount":1,"id":98,"name":"Web 开发"},{"postsCount":11,"id":99,"name":"互联网"},{"postsCount":1,"id":108,"name":"移动互联网"},{"postsCount":2,"id":112,"name":"创业"},{"postsCount":1,"id":134,"name":"硅谷公司"},{"postsCount":2,"id":225,"name":"前端开发"},{"postsCount":1,"id":232,"name":"高效工作"},{"postsCount":3,"id":253,"name":"游戏"},{"postsCount":3,"id":350,"name":"人工智能"},{"postsCount":1,"id":368,"name":"产品经理"},{"postsCount":1,"id":405,"name":"成功"},{"postsCount":1,"id":413,"name":"百度"},{"postsCount":1,"id":415,"name":"旅游"},{"postsCount":1,"id":471,"name":"产品设计"},{"postsCount":2,"id":472,"name":"美国"},{"postsCount":3,"id":520,"name":"苹果公司 (Apple Inc.)"},{"postsCount":2,"id":622,"name":"面试"},{"postsCount":3,"id":707,"name":"程序员"},{"postsCount":1,"id":708,"name":"软件开发"},{"postsCount":1,"id":757,"name":"星际争霸"},{"postsCount":1,"id":866,"name":"开源软件"},{"postsCount":1,"id":872,"name":"Python"},{"postsCount":3,"id":962,"name":"伊隆 · 马斯克（Elon Musk）"},{"postsCount":1,"id":988,"name":"教育"},{"postsCount":1,"id":1186,"name":"Square"},{"postsCount":1,"id":1354,"name":"编程"},{"postsCount":1,"id":1575,"name":"成长"},{"postsCount":1,"id":1750,"name":"手机游戏"},{"postsCount":1,"id":1771,"name":"计算机"},{"postsCount":2,"id":1838,"name":"环球旅行"},{"postsCount":1,"id":2171,"name":"回忆"},{"postsCount":7,"id":2476,"name":"互联网创业"},{"postsCount":1,"id":2510,"name":"SaaS"},{"postsCount":1,"id":2566,"name":"职场"},{"postsCount":1,"id":2592,"name":"WWDC"},{"postsCount":3,"id":3074,"name":"数据分析"},{"postsCount":3,"id":3123,"name":"代码"},{"postsCount":1,"id":3132,"name":"笔记本电脑"},{"postsCount":1,"id":3251,"name":"留学"},{"postsCount":1,"id":3282,"name":"Airbnb（爱彼迎）"},{"postsCount":1,"id":3631,"name":"路由器"},{"postsCount":1,"id":4392,"name":"电子竞技"},{"postsCount":1,"id":4408,"name":"网速"},{"postsCount":1,"id":4624,"name":"计算机技术"},{"postsCount":2,"id":5231,"name":"谷歌 (Google)"},{"postsCount":2,"id":5288,"name":"GitHub"},{"postsCount":1,"id":5619,"name":"社会现象"},{"postsCount":1,"id":5647,"name":"侵权"},{"postsCount":2,"id":5765,"name":"科技公司"},{"postsCount":1,"id":5851,"name":"科技趋势"},{"postsCount":1,"id":6086,"name":"收入"},{"postsCount":1,"id":7354,"name":"系统设计"},{"postsCount":1,"id":7500,"name":"Sketch"},{"postsCount":1,"id":7563,"name":"计算机网络"},{"postsCount":1,"id":7583,"name":"职场新人"},{"postsCount":1,"id":7897,"name":"程序员修养"},{"postsCount":1,"id":9296,"name":"自由"},{"postsCount":1,"id":9500,"name":"招聘"},{"postsCount":1,"id":9602,"name":"文化衫"},{"postsCount":3,"id":9611,"name":"程序员面试"},{"postsCount":1,"id":10336,"name":"专注"},{"postsCount":2,"id":11096,"name":"优步（Uber）"},{"postsCount":2,"id":11107,"name":"互联网行业"},{"postsCount":1,"id":11563,"name":"自驾游"},{"postsCount":1,"id":11668,"name":"互联网面试"},{"postsCount":1,"id":11686,"name":"航空母舰"},{"postsCount":1,"id":13473,"name":"互联网行业工资"},{"postsCount":1,"id":13705,"name":"Google I/O"},{"postsCount":1,"id":14043,"name":"美国梦"},{"postsCount":1,"id":15094,"name":"虚拟现实（VR）"},{"postsCount":1,"id":15344,"name":"励志"},{"postsCount":1,"id":15816,"name":"谢莉尔·桑德伯格（Sheryl Sandberg）"},{"postsCount":2,"id":16438,"name":"留学美国"},{"postsCount":1,"id":16528,"name":"Hack"},{"postsCount":1,"id":16887,"name":"时间规划"},{"postsCount":1,"id":17299,"name":"TechCrunch"},{"postsCount":1,"id":17648,"name":"安迪·鲁宾（Andy Rubin）"},{"postsCount":4,"id":17686,"name":"Android"},{"postsCount":2,"id":18022,"name":"Discovery"},{"postsCount":1,"id":19280,"name":"阿里巴巴工作"},{"postsCount":1,"id":19465,"name":"互联网公司"},{"postsCount":1,"id":21549,"name":"在线文档"},{"postsCount":1,"id":21796,"name":"计算机语言"},{"postsCount":4,"id":21973,"name":"直播"},{"postsCount":1,"id":22949,"name":"Haiping Zhao（赵海平）"},{"postsCount":1,"id":23621,"name":"迪拜"},{"postsCount":1,"id":24056,"name":"TopCoder"},{"postsCount":1,"id":25257,"name":"算法与数据结构"},{"postsCount":1,"id":25626,"name":"冒险"},{"postsCount":3,"id":27614,"name":"卫星地图"},{"postsCount":1,"id":27919,"name":"职场心理"},{"postsCount":2,"id":30429,"name":"攻略"},{"postsCount":1,"id":31397,"name":"ACM 竞赛"},{"postsCount":2,"id":33086,"name":"Facebook F8"},{"postsCount":1,"id":38098,"name":"希拉里·克林顿（Hillary Clinton）"},{"postsCount":1,"id":40922,"name":"天猫"},{"postsCount":1,"id":41171,"name":"美国大选"},{"postsCount":1,"id":41849,"name":"北美留学"},{"postsCount":1,"id":41864,"name":"Sheryl Sandberg"},{"postsCount":1,"id":44198,"name":"Android 开发者"},{"postsCount":2,"id":68548,"name":"IT 职场"},{"postsCount":2,"id":70042,"name":"特斯拉汽车 (Tesla Motors)"},{"postsCount":1,"id":82965,"name":"Quip"},{"postsCount":1,"id":83899,"name":"Growth Hack"},{"postsCount":1,"id":88948,"name":"Tesla Model S"},{"postsCount":1,"id":91446,"name":"美国房价"},{"postsCount":1,"id":96327,"name":"数据可视化设计"},{"postsCount":3,"id":98461,"name":"精灵宝可梦（Pokémon）"},{"postsCount":1,"id":100137,"name":"互联网薪水"},{"postsCount":1,"id":115734,"name":"斗鱼直播"},{"postsCount":1,"id":122126,"name":"智能路由器"},{"postsCount":1,"id":131131,"name":"华尔街之狼（电影）"},{"postsCount":1,"id":135680,"name":"Docker"},{"postsCount":1,"id":141212,"name":"程序员求职"},{"postsCount":1,"id":152976,"name":"Facebook 公司"},{"postsCount":15,"id":153588,"name":"硅谷就业"},{"postsCount":1,"id":154182,"name":"Tesla Model 3"},{"postsCount":2,"id":154911,"name":"分享经济"},{"postsCount":1,"id":155397,"name":"黑科技"},{"postsCount":2,"id":156416,"name":"React"},{"postsCount":1,"id":157009,"name":"虎鲸"},{"postsCount":2,"id":159435,"name":"Vue.js"},{"postsCount":1,"id":162652,"name":"石墨文档"},{"postsCount":3,"id":163746,"name":"独角兽公司"},{"postsCount":2,"id":164476,"name":"Pokémon Go"}]
     * pendingName :
     * avatar : {"id":"f1ef44999","template":"https://pic2.zhimg.com/{id}_{size}.jpg"}
     * canManage : false
     * description : 微信公众号: qc_empire
     知乎: http://www.zhihu.com/people/qin.chao

     这里是我的小站, 关于我喜欢的, 我思考的, 以及我经历的一切:
     如何去Facebook及硅谷列强工作；
     如何申请去北美计算机牛校（比如CMU,Stanford,etc）；
     Facebook工作和感受；
     Zuckerburg 2015年书友会和干货；
     美国留学和实习；
     Tesla特斯拉电动汽车和Elon Musk；
     互联网创业；
     硅谷科技前言；
     投资和财务自由；
     卡耐基梅隆大学。
     * pendingTopics : []
     * nameCanEditUntil : 0
     * reason :
     * banUntil : 0
     * slug : qinchao
     * name : 跨越美利坚 - 面试、创业、技术培训
     * url : /qinchao
     * intro : Salvation Lies Within.
     * topicsCanEditUntil : 0
     * activateAuthorRequested : none
     * commentPermission : anyone
     * following : false
     * postsCount : 141
     * canPost : false
     */

    public int followersCount;
    public CreatorEntity creator;
    public String activateState;
    public String href;
    public boolean acceptSubmission;
    public boolean firstTime;
    public String pendingName;
    public AvatarEntityX avatar;
    public boolean canManage;
    public String description;
    public int nameCanEditUntil;
    public String reason;
    public int banUntil;
    public String slug;
    public String name;
    public String url;
    public String intro;
    public int topicsCanEditUntil;
    public String activateAuthorRequested;
    public String commentPermission;
    public boolean following;
    public int postsCount;
    public boolean canPost;
    public List<TopicsEntity> topics;
    public List<PostTopicsEntity> postTopics;
    public List<?> pendingTopics;

    public static class CreatorEntity {
        /**
         * profileUrl : https://www.zhihu.com/people/qin.chao
         * bio : 曾经沧海难为水的Facebook早期员工
         * hash : 7407795460968de9aa7f60d890b29c39
         * uid : 26820170743808
         * isOrg : false
         * description : 北美FLAG找工作攻略，硅谷前沿，计算机牛校申请心得、大学经验和职业发展道路建议（计算机）。
         *平时尽量挤时间知乎答题，专栏会保持更新，有问题想问我的，请前往：
         (1)「值乎」提问（https://www.zhihu.com/zhi/people/723683409859219456）。
         (2) 微信公众号：qc_empire
         - 本人已委托维权骑士（http://rightknights.com）为我的文章进行维权行动。
         * isOrgWhiteList : false
         * slug : qin.chao
         * avatar : {"id":"d377edfcb","template":"https://pic4.zhimg.com/{id}_{size}.jpg"}
         * name : 覃超
         */

        public String profileUrl;
        public String bio;
        public String hash;
        public long uid;
        public boolean isOrg;
        public String description;
        public boolean isOrgWhiteList;
        public String slug;
        public AvatarEntity avatar;
        public String name;

        public static class AvatarEntity {
            /**
             * id : d377edfcb
             * template : https://pic4.zhimg.com/{id}_{size}.jpg
             */
            public String id;
            public String template;
        }
    }

    public static class AvatarEntityX {
        /**
         * id : f1ef44999
         * template : https://pic2.zhimg.com/{id}_{size}.jpg
         */

        public String id;
        public String template;
    }

    public static class TopicsEntity {
        /**
         * url : https://www.zhihu.com/topic/19550560
         * id : 19550560
         * name : 创业
         */

        public String url;
        public String id;
        public String name;
    }

    public static class PostTopicsEntity {
        /**
         * postsCount : 1
         * id : 5
         * name : 创业公司
         */

        public int postsCount;
        public int id;
        public String name;
    }


    public int getFollowersCount() {
        return followersCount;
    }

    public CreatorEntity getCreator() {
        return creator;
    }

    public String getActivateState() {
        return activateState;
    }

    public String getHref() {
        return href;
    }

    public boolean isAcceptSubmission() {
        return acceptSubmission;
    }

    public boolean isFirstTime() {
        return firstTime;
    }

    public String getPendingName() {
        return pendingName;
    }

    public AvatarEntityX getAvatar() {
        return avatar;
    }

    public boolean isCanManage() {
        return canManage;
    }

    public String getDescription() {
        return description;
    }

    public int getNameCanEditUntil() {
        return nameCanEditUntil;
    }

    public String getReason() {
        return reason;
    }

    public int getBanUntil() {
        return banUntil;
    }

    public String getSlug() {
        return slug;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getIntro() {
        return intro;
    }

    public int getTopicsCanEditUntil() {
        return topicsCanEditUntil;
    }

    public String getActivateAuthorRequested() {
        return activateAuthorRequested;
    }

    public String getCommentPermission() {
        return commentPermission;
    }

    public boolean isFollowing() {
        return following;
    }

    public int getPostsCount() {
        return postsCount;
    }

    public boolean isCanPost() {
        return canPost;
    }

    public List<TopicsEntity> getTopics() {
        return topics;
    }

    public List<PostTopicsEntity> getPostTopics() {
        return postTopics;
    }

    public List<?> getPendingTopics() {
        return pendingTopics;
    }

    @Override
    public String toString() {
        return "ArticleEntity{" +
                "followersCount=" + followersCount +
                ", creator=" + creator +
                ", activateState='" + activateState + '\'' +
                ", href='" + href + '\'' +
                ", acceptSubmission=" + acceptSubmission +
                ", firstTime=" + firstTime +
                ", pendingName='" + pendingName + '\'' +
                ", avatar=" + avatar +
                ", canManage=" + canManage +
                ", description='" + description + '\'' +
                ", nameCanEditUntil=" + nameCanEditUntil +
                ", reason='" + reason + '\'' +
                ", banUntil=" + banUntil +
                ", slug='" + slug + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", intro='" + intro + '\'' +
                ", topicsCanEditUntil=" + topicsCanEditUntil +
                ", activateAuthorRequested='" + activateAuthorRequested + '\'' +
                ", commentPermission='" + commentPermission + '\'' +
                ", following=" + following +
                ", postsCount=" + postsCount +
                ", canPost=" + canPost +
                ", topics=" + topics +
                ", postTopics=" + postTopics +
                ", pendingTopics=" + pendingTopics +
                '}';
    }
}
