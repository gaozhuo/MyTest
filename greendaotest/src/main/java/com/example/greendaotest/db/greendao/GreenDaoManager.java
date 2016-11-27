package com.example.greendaotest.db.greendao;

import android.content.Context;

import com.example.greendaotest.db.greendao.gen.DaoMaster;
import com.example.greendaotest.db.greendao.gen.DaoSession;

/**
 * Created by gaozhuo on 2016/11/27.
 */

public class GreenDaoManager {
    private static volatile GreenDaoManager mInstance;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;

    private GreenDaoManager(Context context) {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, "db-user");
        mDaoMaster = new DaoMaster(helper.getWritableDb());
        mDaoSession = mDaoMaster.newSession();
    }

    public static GreenDaoManager getInstance(Context context) {
        if (mInstance == null) {
            synchronized (GreenDaoManager.class) {
                if (mInstance == null) {
                    mInstance = new GreenDaoManager(context.getApplicationContext());
                }
            }
        }
        return mInstance;
    }

    public DaoSession getDaoSession(){
        return mDaoSession;
    }

    public DaoSession newDaoSession(){
        return mDaoMaster.newSession();
    }
}
