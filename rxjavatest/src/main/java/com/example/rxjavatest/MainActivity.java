package com.example.rxjavatest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                testRxJava2();
            }
        });
    }

    private void testRxJava2() {
        Observable<Integer> observable = Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                subscriber.onNext(123456);
                subscriber.onCompleted();
            }
        });

        Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                Log.d("gaozhuo", "s=" + s);
            }
        };

        Observable<String> observable2 =  observable.map(new Func1<Integer, String>() {
            @Override
            public String call(Integer integer) {
                return integer + " hahaha";
            }
        });

        observable2.subscribe(subscriber);

    }

    private void testRxJava() {
        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                Log.d("gaozhuo", "call thread =" + Thread.currentThread().getId());
                subscriber.onNext("hello world");
                subscriber.onNext("RxJava");
                subscriber.onCompleted();

            }
        });

        Observable<String> observable2 = Observable.just("111", "222", "333");

        Observer<String> observer = new Observer<String>() {
            @Override
            public void onCompleted() {
                Log.d("gaozhuo", "onCompleted");

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                Log.d("gaozhuo", "s=" + s);

            }
        };

        Subscriber<String> subscriber = new Subscriber<String>() {

            @Override
            public void onCompleted() {
                Log.d("gaozhuo", "onCompleted");
                Log.d("gaozhuo", "onCompleted thread =" + Thread.currentThread().getId());

            }

            @Override
            public void onError(Throwable e) {
                Log.d("gaozhuo", "onError");
            }

            @Override
            public void onNext(String s) {
                Log.d("gaozhuo", "s=" + s);
                Log.d("gaozhuo", "onNext thread =" + Thread.currentThread().getId());

            }
        };

        Action1<String> onNextAction = new Action1<String>() {
            @Override
            public void call(String s) {
                Log.d("gaozhuo", "s=" + s);
            }
        };

        Action1<Throwable> onErrorAction = new Action1<Throwable>() {
            @Override
            public void call(Throwable e) {
                Log.d("gaozhuo", "onError");
            }
        };

        Action0 onCompletedAction = new Action0() {
            @Override
            public void call() {
                Log.d("gaozhuo", "onCompleted");
            }
        };

        //observable.subscribe(subscriber);
        //observable2.subscribe(onNextAction, onErrorAction, onCompletedAction);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);

    }
}
