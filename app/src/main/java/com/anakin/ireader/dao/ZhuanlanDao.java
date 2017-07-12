package com.anakin.ireader.dao;

import android.content.Context;

import com.anakin.ireader.model.entity.ArticleEntity;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

/**
 * 创建者     demo
 * 创建时间   2017/7/4 0004 17:59
 */
public class ZhuanlanDao {
    private Dao<ArticleEntity, Integer> mDao;
    private DatabaseHelper helper;

    public ZhuanlanDao(Context context)
    {
        try
        {
            helper = DatabaseHelper.getHelper(context);
            mDao = helper.getDao(ArticleEntity.class);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public List<ArticleEntity> getAll() {
        try {
            return mDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }


    /**
     * 添加一个Article
     * @param article
     */
    public void add(ArticleEntity article)
    {
        try
        {
            mDao.create(article);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }



    /**
     * 通过Id得到一篇文章
     * @param id
     * @return
     */
    public ArticleEntity get(int id)
    {
        ArticleEntity article = null;
        try
        {
            article = mDao.queryForId(id);

        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return article;
    }

    /**
     * 通过UserId获取所有的文章
     * @param userId
     * @return
     */
    public List<ArticleEntity> listByUserId(int userId)
    {
        try
        {
            return mDao.queryBuilder().where().eq("user_id", userId)
                    .query();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }




}
