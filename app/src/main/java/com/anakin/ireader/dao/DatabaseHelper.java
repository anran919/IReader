package com.anakin.ireader.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;

/**
 * 创建者     demo
 * 创建时间   2016/12/1 0001 15:09
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "user_app_data.db";
    private static DatabaseHelper instance;


    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static synchronized DatabaseHelper getHelper(Context context) {
        context = context.getApplicationContext();
        if (instance == null) {
            synchronized (DatabaseHelper.class) {
                if (instance == null)
                    instance = new DatabaseHelper(context);
            }
        }
        return instance;
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
     /*   try {
            TableUtils.dropTable(connectionSource, CollectionsInfo.class, true);
            TableUtils.dropTable(connectionSource, UsedInfo.class, true);
            onCreate(database, connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
       /* try {
            TableUtils.createTable(connectionSource, CollectionsInfo.class);
            TableUtils.createTable(connectionSource, UsedInfo.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }
}
