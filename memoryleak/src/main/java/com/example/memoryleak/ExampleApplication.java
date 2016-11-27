package com.example.memoryleak;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by gaozhuo on 2016/10/19.
 */

public class ExampleApplication extends Application {

    public static RefWatcher getRefWatcher(Context context) {
        ExampleApplication application = (ExampleApplication) context.getApplicationContext();
        return application.refWatcher;
    }

    private RefWatcher refWatcher;

    @Override
    public void onCreate() {
        super.onCreate();

        if (LeakCanary.isInAnalyzerProcess(this)) {

            // This process is dedicated to LeakCanary for heap analysis.

            // You should not init your app in this process.

            return;

        }

        //refWatcher = LeakCanary.install(this);
        refWatcher = installLeakCanary();
    }

    protected RefWatcher installLeakCanary() {
        RefWatcher refWatcher = LeakCanary.refWatcher(this)
                .listenerServiceClass(LeakUploadService.class)
                .buildAndInstall();
        return refWatcher;
    }


}
