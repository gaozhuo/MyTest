package com.example.roudimage;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;

public class BitmapShaderView2 extends View {

    private BitmapShader bitmapShader = null;
    private Bitmap bitmap = null;
    private Paint paint = new Paint();


    public BitmapShaderView2(Context context) {
        super(context);

        bitmap = ((BitmapDrawable) getResources().getDrawable(R.drawable.ic_test))
                .getBitmap();
        // 构造渲染器BitmapShader
        bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.MIRROR);
    }

    public BitmapShaderView2(Context context, AttributeSet set) {
        super(context, set);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        super.onDraw(canvas);
        paint.setShader(bitmapShader);
        canvas.drawRect(0, 0, 500, 500, paint);
    }

}

