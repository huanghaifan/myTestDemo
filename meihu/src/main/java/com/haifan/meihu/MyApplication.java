package com.haifan.meihu;

import android.app.Application;

import com.haifan.meihu.greendao.GreenDao;

/**
 * Created by youxue on 2017/12/23.
 */

public class MyApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        GreenDao.init(this);
    }
}
