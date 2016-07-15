package com.example.test;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private Button mButton;
    private DownloadManager mDownloadManager;
    private long mDownloadId;
    private BroadcastReceiver mReceiver = new MyBroadcastReceiver();

    private Handler mHandler = new Handler() {
        @Override
        public void dispatchMessage(Message msg) {
            super.dispatchMessage(msg);
            Log.d("gaozhuo", "dispatchMessage");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, VersionUpdateService.class);
//                intent.putExtra("desc", "博德嘉联医生集团掌上医院");
//                intent.putExtra("fileName","bdjl_release.apk");
//                intent.putExtra("url", "http://pkg3.fir.im/da8d87c91d9c293ceb1745f8245248789f6a8510.apk?attname=dGroupDoctor-dachen-release.apk_1.07.apk");
//                startService(intent);

                startDownload();
            }
        });

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(DownloadManager.ACTION_DOWNLOAD_COMPLETE);
        intentFilter.addAction(DownloadManager.ACTION_NOTIFICATION_CLICKED);
        registerReceiver(mReceiver, intentFilter);

    }

    private void startDownload() {
        Log.d(TAG, "download started");
        mDownloadManager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse("http://pkg3.fir.im/da8d87c91d9c293ceb1745f8245248789f6a8510.apk?attname=dGroupDoctor-dachen-release.apk_1.07.apk"));
        //request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI);
        //设置通知栏标题
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setVisibleInDownloadsUi(true);
        request.setTitle("正在下载");
        request.setDescription("博德嘉联医生集团掌上医院");

        request.setMimeType("application/vnd.android.package-archive");
        File file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        if(!file.exists()){
            file.mkdir();
        }

        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "bdjl_release.apk");
        mDownloadId = mDownloadManager.enqueue(request);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mReceiver);
        Log.d("gaozhuo", "onDestroy");
    }

    class MyBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d(TAG, "download finished");
            Log.d(TAG, "action=" + intent.getAction());
            long id = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1);
            DownloadManager.Query query = new DownloadManager.Query();
            query.setFilterById(id);
            Cursor cursor =  mDownloadManager.query(query);
            if(cursor.moveToFirst()){
                int  index = cursor.getColumnIndex(DownloadManager.COLUMN_LOCAL_FILENAME);
                Log.d(TAG, "filename=" + cursor.getString(index));
                index = cursor.getColumnIndex(DownloadManager.COLUMN_LOCAL_URI);
                Log.d(TAG, "uri=" + cursor.getString(index));
            }
            cursor.close();
        }
    };


    class MyTask implements Runnable {

        @Override
        public void run() {
            try {
                Thread.currentThread().sleep(20 * 1000);
                Log.d("gaozhuo", "MyTask is finished");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
