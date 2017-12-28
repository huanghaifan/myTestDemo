package com.haifan.meihu.view;

import com.haifan.meihu.base.mvp.BaseView;
import com.haifan.meihu.model.TidBean;
import com.haifan.meihu.model.testmodel.TestModel;

import java.util.List;

/**
 * Created by youxue on 2017/12/14.
 */

public interface TestView extends BaseView {

    void showLoading();

    void hideLoading();

    void getTidSuccess(List<TidBean> tidList);

    void getTidFail(String msg);

    void getTestModelsuccess(List<TestModel> testModel);

    void getTestModeFail(String msg);
}
