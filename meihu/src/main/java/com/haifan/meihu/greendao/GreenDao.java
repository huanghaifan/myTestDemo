package com.haifan.meihu.greendao;

import android.content.Context;

import com.haifan.meihu.config.AppConfig;

/**
 * Created by youxue on 2017/12/23.
 */

public class GreenDao {

    private static DaoSession daoSession;

    public static void init(Context context)
    {
        final DaoMaster.OpenHelper openHelper = new AppOpenHelper(context, AppConfig.DBNAME);
        DaoMaster daoMaster = new DaoMaster(openHelper.getWritableDb());
        daoSession = daoMaster.newSession();
    }

    public static DaoSession getInstance()
    {
        return daoSession;
    }
}
