package com.example.greendaotest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.greendaotest.db.entity.User;
import com.example.greendaotest.db.greendao.GreenDaoManager;
import com.example.greendaotest.db.greendao.gen.UserDao;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void insert(View v) {
        GreenDaoManager manager = GreenDaoManager.getInstance(this);
        UserDao userDao = manager.getDaoSession().getUserDao();

        for (int i = 0; i < 10; i++) {
            User user = new User();
            //user.setId(i);
            user.setName("name" + i);
            user.setAge(10 + i);
            user.setSex(1);
            userDao.insert(user);
        }


        Toast.makeText(this, "successful", Toast.LENGTH_SHORT).show();

    }

    public void delete(View v) {

    }

    public void update(View v) {

    }

    public void query(View v) {
        GreenDaoManager manager = GreenDaoManager.getInstance(this);
        UserDao userDao = manager.getDaoSession().getUserDao();

        List<User> users = userDao.loadAll();
        for (User user : users) {
            Log.d("gaozhuo", user.toString());
        }

    }
}
