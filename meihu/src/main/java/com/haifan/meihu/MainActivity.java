package com.haifan.meihu;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import com.haifan.meihu.R;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.functions.Func1;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "rxjavaActivity";
    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.btn)
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

//        btn.setOnClickListener(v -> tv.setText("lambda expresson"));
    }

    private void test() {
//        //1) 创建 Observer
//        Observable<String> observable = new Observable<String>(){
//
//        };

        //数据发射源
        Observable<String> sender = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("Hi，Weavey！");  //发送数据"Hi，Weavey！"
            }
        });

        //数据接收源
        Observer<String> receiver = new Observer<String>() {
            @Override
            public void onCompleted() {
                //数据接受完成时调用
            }

            @Override
            public void onError(Throwable e) {
                //发生错误时调用
            }

            @Override
            public void onNext(String s) {
                //正常接收数据调用
                Log.i(TAG, s);
            }
        };
        sender.subscribe(receiver);

        //2.使用just( )，将为你创建一个Observable并自动为你调用onNext( )发射数据
        Observable justObservable = Observable.just("just1", "just2");//依次发送"just1"和"just2"

        //3.使用from( )，遍历集合，发送每个item：
        List<String> list = new ArrayList<>();
        list.add("from1");
        list.add("from2");
        list.add("from3");
        Observable fromObservable = Observable.from(list);

        //4.使用defer( )，有观察者订阅时才创建Observable，并且为每个观察者创建一个新的Observable：
        Observable deferObservable = Observable.defer(new Func0<Observable<String>>() {
            @Override
            public Observable<String> call() {
                return Observable.just("deferObservable");
            }
        });

        //5.使用interval( ),创建一个按固定时间间隔发射整数序列的Observable，可用作定时器
        Observable intervalObservable = Observable.interval(1, TimeUnit.SECONDS);

        //6.使用range( ),创建一个发射特定整数序列的Observable，第一个参数为起始值，第二个为发送的个数，如果为0则不发送，负数则抛异常：
        Observable rangObservable = Observable.range(10, 5);//将发送整数10，11，12，13，14

        //7.使用timer( ),创建一个Observable，它在一个给定的延迟后发射一个特殊的值，等同于Android中Handler的postDelay( )方法
        Observable timeObservable = Observable.timer(3, TimeUnit.SECONDS);//3秒后发射一个值

        //8.使用repeat( ),创建一个重复发射特定数据的Observable:
        Observable repeatObservable = Observable.just("repeatObservable").repeat(3);//重复发射3次
    }

    private void test2() {
        Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {

            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {

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

            }
        };

        //map()操作符
        Observable.just("images/logo.png")//输入类型String
                .map(new Func1<String, Bitmap>()
        {
            @Override
            public Bitmap call(String s) {
                return null; // 返回类型 Bitmap
            }
        }).subscribe(new Action1<Bitmap>() {
            @Override
            public void call(Bitmap bitmap) {

            }
        });
    }

    @OnClick(R.id.btn)
    public void onViewClicked()
    {
        Observable<String> sender = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("Hi，Weavey！");  //发送数据"Hi，Weavey！"
            }
        });
//        Observer<String> observer = new Observer<String>() {
//            @Override
//            public void onCompleted() {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onNext(String s) {
//                tv.setText(s);
//            }
//        };
//        sender.subscribe(observer);
//        Subscriber<String> subscriber = new Subscriber<String>() {
//            @Override
//            public void onCompleted() {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onNext(String s) {
//
//            }
//        };
//        sender.subscribe(subscriber);

        Observable observable = Observable.just("just1","just2","just3");
//        Subscriber<String> subscriber = new Subscriber<String>() {
//            @Override
//            public void onCompleted() {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onNext(String s) {
//
//            }
//
//            @Override
//            public void onStart() {
//                super.onStart();
//            }
//        };
//        observable.subscribe(subscriber);

        Action1<String> onNextAction = new Action1<String>() {
            @Override
            public void call(String s)
            {
                Log.i(TAG,s);
            }
        };
        observable.subscribe(onNextAction);

//        Observer observer = new Observer() {
//            @Override
//            public void onCompleted() {
//                Log.i(TAG, "onCompleted");
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Log.i(TAG, e.toString());
//            }
//
//            @Override
//            public void onNext(Object o)
//            {
//                Log.i(TAG, (String) o);
//            }
//        };
//        observable.subscribe(observer);

//        //3.使用from( )，遍历集合，发送每个item：
//        List<String> list = new ArrayList<>();
//        list.add("from1");
//        list.add("from2");
//        list.add("from3");
//        Observable fromObservable = Observable.from(list);
//        Observer observer = new Observer() {
//            @Override
//            public void onCompleted() {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onNext(Object o) {
//                Log.i(TAG, (String) o);
//            }
//        };
//        fromObservable.subscribe(observer);
        new Thread(() -> System.out.println("111")).start();
        new Thread(new Runnable() {
            @Override
            public void run()
            {
                System.out.println("111");
            }
        }).start();
    }
}
