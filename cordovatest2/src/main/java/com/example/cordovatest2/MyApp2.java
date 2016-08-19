package com.example.cordovatest2;

import android.app.Application;
import android.util.Log;

/**
 * Created by gzhuo on 2016/8/16.
 */
public class MyApp2 extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("gaozhuo", "app onCreate");
    }
}
