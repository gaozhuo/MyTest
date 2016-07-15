package com.example.test;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Button;

/**
 * Created by gzhuo on 2016/6/12.
 */
public class ButtonEx extends Button {
    public ButtonEx(Context context) {
        super(context);
    }

    public ButtonEx(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ButtonEx(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d("gaozhuo", "isHardwareAccelerated2=" +canvas.isHardwareAccelerated());
    }
}
