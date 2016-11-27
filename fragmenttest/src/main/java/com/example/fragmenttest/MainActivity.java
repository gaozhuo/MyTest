package com.example.fragmenttest;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button mAdd;
    private FragmentManager mFragmentManager;
    private AFragment mAFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFragmentManager = getSupportFragmentManager();
        mAFragment = new AFragment();


        findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction transaction = mFragmentManager.beginTransaction();
                transaction.replace(R.id.container, new AFragment(), "afragment");
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });

        findViewById(R.id.detach).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                FragmentTransaction transaction = mFragmentManager.beginTransaction();
//               // transaction.detach(mAFragment);
//                transaction.remove(mAFragment);
//                transaction.commit();

                mFragmentManager.popBackStack();


            }
        });

        findViewById(R.id.attach).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction transaction = mFragmentManager.beginTransaction();
                transaction.attach(mAFragment);
                transaction.commit();

            }
        });
    }
}
