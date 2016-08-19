package com.example.dialogtest;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    public LinearLayout mLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLayout = (LinearLayout) findViewById(R.id.layout);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //test2();

                Button btn1 = new Button(MainActivity.this);
                btn1.setLayoutParams(new RelativeLayout.LayoutParams(200,200));
                btn1.setText("hahah");
                mLayout.addView(btn1);
            }
        });
    }

    private void test() {
        Dialog dialog = new Dialog(this);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        //dialog.setTitle("Hello");
        dialog.setContentView(R.layout.alert_dialog);
        dialog.show();

    }

    private void test2(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("hello");
        builder.setCustomTitle(new Button(this));
        builder.setMessage("how are you");
        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();
//        FrameLayout fl = (FrameLayout) findViewById(android.R.id.custom);
//        fl.addView(new Button(this));
    }
}
