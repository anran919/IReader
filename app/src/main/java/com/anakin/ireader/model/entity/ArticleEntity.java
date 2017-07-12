package com.anakin.ireader.model.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * 创建者     demo
 * 创建时间   2016/11/25 0025 18:55
 */
@DatabaseTable(tableName ="zhulan_user")
public class ArticleEntity implements Serializable{

    // 关联主键
    @DatabaseField(generatedId = true)
    public int id;
    @DatabaseField
    public String name;
    @DatabaseField
    public int followersCount;
    @DatabaseField
    public int postsCount;
    @DatabaseField
    public String description;
    @DatabaseField
    private String avatar_id;
    @DatabaseField
    public String avatar_template;
    @DatabaseField
    public String slug;

    public ArticleEntity() {
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getFollowersCount() {
        return followersCount;
    }

    public int getPostsCount() {
        return postsCount;
    }

    public String getDescription() {
        return description;
    }

    public String getAvatar_id() {
        return avatar_id;
    }

    public String getAvatar_template() {
        return avatar_template;
    }

    public String getSlug() {
        return slug;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFollowersCount(int followersCount) {
        this.followersCount = followersCount;
    }

    public void setPostsCount(int postsCount) {
        this.postsCount = postsCount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAvatar_id(String avatar_id) {
        this.avatar_id = avatar_id;
    }

    public void setAvatar_template(String avatar_template) {
        this.avatar_template = avatar_template;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    @Override
    public String toString() {
        return "ArticleEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", followersCount=" + followersCount +
                ", postsCount=" + postsCount +
                ", description='" + description + '\'' +
                ", avatar_id='" + avatar_id + '\'' +
                ", avatar_template='" + avatar_template + '\'' +
                ", slug='" + slug + '\'' +
                '}';
    }
}
