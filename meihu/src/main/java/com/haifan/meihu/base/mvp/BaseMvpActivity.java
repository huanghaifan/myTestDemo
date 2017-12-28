package com.haifan.meihu.base.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.haifan.meihu.base.BaseActivity;

/**
 * Created by youxue on 2017/12/14.
 */

public abstract class BaseMvpActivity<P extends BasePresenter> extends BaseActivity{

    protected P mvpPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        mvpPresenter = createPresenter();
        super.onCreate(savedInstanceState);
    }

    protected abstract P createPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(null != mvpPresenter)
        {
            mvpPresenter.deatchView();
        }
    }
}
