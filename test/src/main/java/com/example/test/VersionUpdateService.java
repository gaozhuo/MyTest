package com.example.test;

import android.app.DownloadManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Environment;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;

import java.io.File;

public class VersionUpdateService extends Service {
    private static final String TAG = VersionUpdateService.class.getSimpleName();
    private DownloadManager mDownloadManager;
    private long mDownloadId;
    private BroadcastReceiver mReceiver;
    private String mDesc;
    private String mFileName;
    private String mUrl;


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mDesc = intent.getStringExtra("desc");
        mFileName = intent.getStringExtra("fileName");
        mUrl = intent.getStringExtra("url");

        if (TextUtils.isEmpty(mUrl)) {
            stopSelf();
        }

        mReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Log.d(TAG, "download finished");
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setDataAndType(Uri.fromFile(new File(Environment.getExternalStorageDirectory() + "/download/" + mFileName)),
                        "application/vnd.android.package-archive");
                startActivity(intent);
                stopSelf();
            }
        };

        registerReceiver(mReceiver, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
        startDownload();
        return Service.START_STICKY;
    }

    @Override
    public void onDestroy() {
        unregisterReceiver(mReceiver);
        super.onDestroy();
    }

    private void startDownload() {
        Log.d(TAG, "download started");
        mDownloadManager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(mUrl));
        //设置通知栏标题
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        //request.setVisibleInDownloadsUi(false);
        request.setTitle("正在下载");
        request.setDescription(mDesc);

        request.setMimeType("application/vnd.android.package-archive");
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, mFileName);
        mDownloadId = mDownloadManager.enqueue(request);
    }
}