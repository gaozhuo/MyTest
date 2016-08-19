package org.apache.cordova;

import android.app.Application;
import android.util.Log;

/**
 * Created by gzhuo on 2016/8/16.
 */
public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("gaozhuo", "library onCreate");
    }
}
