package com.example.test;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import dalvik.system.DexFile;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private Button mButton;
    private ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
    private int mCount = 0;
    private MyTask mMyTask;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("hahaha", "onCreate");
        Log.d("hahaha","c1=" + getClassLoader());
        Log.d("hahaha","c2=" + getClassLoader().getParent());
        Log.d("hahaha","c3=" + ClassLoader.getSystemClassLoader());
        Log.d("hahaha","c4=" + ClassLoader.getSystemClassLoader().getParent());

        mTextView = (TextView) findViewById(R.id.textView);
        mButton = (Button) findViewById(R.id.btn);
        mButton.hashCode();
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("hahahaha");
                getApplicationContext().sendBroadcast(intent);
            }
        });


    }

    private BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("hahaha", "context=" + context);
        }
    };


    class MyTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            try {
                Thread.sleep(10 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            mCount = 999;
            Log.d("hahaha", "count =" + mCount);

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            mTextView.setText("count=" + mCount);
            Log.d("hahaha", "finnish=" + isDestroyed());
            if (!isDestroyed()) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("title")
                        .setMessage("hello world")
                        .show();
            }

        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter filter = new IntentFilter("hahahaha");
        getApplicationContext().registerReceiver(mReceiver, filter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("hahaha", "onPause");
        unregisterReceiver(mReceiver);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("hahaha", "onDestroy");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("hahaha", "onStop");
    }
}
