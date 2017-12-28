package com.haifan.meihu.presenter;

import com.haifan.meihu.base.mvp.BasePresenter;
import com.haifan.meihu.model.TidBean;
import com.haifan.meihu.model.testmodel.TestModel;
import com.haifan.meihu.retrofit.ApiCallBack;
import com.haifan.meihu.view.TestView;

import java.util.List;

/**
 * Created by youxue on 2017/12/14.
 */

public class TestPresenter extends BasePresenter<TestView> {

    public TestPresenter(TestView view) {
        attachView(view);
    }

    public void getTid(String openid,String tel,String pwd,String guid,String cid,String type,String subjectId)
    {
        mvpView.showLoading();
        addSubscription(apiStores.getTid2(openid, tel, pwd, guid, cid, type, subjectId), new ApiCallBack<List<TidBean>>() {

            @Override
            public void onSuccess(List<TidBean> model)
            {
                mvpView.getTidSuccess(model);
            }

            @Override
            public void onFailure(String msg)
            {
                mvpView.getTidFail(msg);
            }

            @Override
            public void onFinish()
            {

            }
        });
    }

    public void getTestModel(String openid,String tel,String pwd,String guid,String tid,String type,String subjectId)
    {
        addSubscription(apiStores.getTestModel(openid, tel, pwd, guid, tid, type, subjectId), new ApiCallBack<List<TestModel>>() {

            @Override
            public void onSuccess(List<TestModel> model)
            {
                mvpView.getTestModelsuccess(model);
            }

            @Override
            public void onFailure(String msg)
            {
                mvpView.getTestModeFail(msg);
            }

            @Override
            public void onFinish()
            {
                mvpView.hideLoading();
            }
        });
    }
}
