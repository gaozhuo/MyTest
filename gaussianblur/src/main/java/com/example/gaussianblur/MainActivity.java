package com.example.gaussianblur;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image = (ImageView) findViewById(R.id.picture);

        findViewById(R.id.controls).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image.setDrawingCacheEnabled(true);
                image.buildDrawingCache();
                Bitmap srcBmp = image.getDrawingCache();
                long startTime = SystemClock.elapsedRealtime();
                //Bitmap destBmp = BitmapUtils.blurBitmap(getApplicationContext(), srcBmp, 25.0f);
                Bitmap destBmp = BitmapUtils.doBlur(srcBmp, 25, true);
                long endTime = SystemClock.elapsedRealtime();
                Log.d("gaozhuo", "time=" + (endTime - startTime));
                image.setImageBitmap(destBmp);
            }
        });
    }


}
