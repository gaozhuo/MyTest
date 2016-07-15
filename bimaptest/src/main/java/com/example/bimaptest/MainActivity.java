package com.example.bimaptest;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView = (ImageView) findViewById(R.id.imageView);

        ActivityManager manager = (ActivityManager)getSystemService(Context.ACTIVITY_SERVICE);
        int heapSize = manager.getMemoryClass();
        Log.d("gaozhuo", "heapSize=" + heapSize);


        BitmapFactory.Options options = new BitmapFactory.Options();

        int targetDensity = getResources().getDisplayMetrics().densityDpi;
        //Log.d("gaozhuo", "densityDpi=" + targetDensity);

//        options.inScaled = false;
//        options.inDensity = 4;
//        options.inTargetDensity = 8;
//        options.inJustDecodeBounds = false;
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.archive_document);
//        Log.d("gaozhuo", "bitmap density=" + bitmap.getDensity());
//        Log.d("gaozhuo", "bitmap size=" + bitmap.getByteCount());
//        Log.d("gaozhuo", "bitmap width=" + bitmap.getWidth());
//        Log.d("gaozhuo", "bitmap height=" + bitmap.getHeight());
        //bitmap.setDensity(120);
        //mImageView.setImageResource(R.drawable.shape_white_bg_normal);
        Drawable drawable = getResources().getDrawable(R.drawable.shape_white_bg_normal);
        Log.d("gaozhuo", "drawable=" + drawable);
        Log.d("gaozhuo", "drawable width=" + drawable.getIntrinsicWidth());
        Log.d("gaozhuo", "drawable height=" + drawable.getIntrinsicHeight());

        mImageView.setBackgroundResource(R.drawable.shape_white_bg_normal);


    }
}
