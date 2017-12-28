package com.haifan.meihu.base.mvp;

import com.haifan.meihu.retrofit.ApiClient;
import com.haifan.meihu.retrofit.ApiStores;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by youxue on 2017/12/14.
 */

public class BasePresenter<V> {

    public V mvpView;
    private CompositeSubscription mCompositeSubscription;
    protected ApiStores apiStores;

    public void attachView(V mvpView)
    {
        this.mvpView = mvpView;
        apiStores = ApiClient.getInstance().create(ApiStores.class);
    }

    public void deatchView()
    {
        mvpView = null;
        onUnsubscribe();
    }

    public void addSubscription(Observable observable, Subscriber subscriber)
    {
        if(mCompositeSubscription == null)
        {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber));
    }

    /**
     * RXjava取消注册，以避免内存泄露
     */
    public void onUnsubscribe()
    {
        if(mCompositeSubscription != null && mCompositeSubscription.hasSubscriptions())
        {
            mCompositeSubscription.unsubscribe();
        }
    }
}
