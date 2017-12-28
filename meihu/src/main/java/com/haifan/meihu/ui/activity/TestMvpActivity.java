package com.haifan.meihu.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.haifan.meihu.base.mvp.BaseMvpActivity;
import com.haifan.meihu.model.TidBean;
import com.haifan.meihu.model.testmodel.TestModel;
import com.haifan.meihu.presenter.TestPresenter;
import com.haifan.meihu.view.TestView;
import com.haifan.meihu.R;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by youxue on 2017/12/14.
 */

public class TestMvpActivity extends BaseMvpActivity<TestPresenter> implements TestView {

    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.btn)
    Button btn;
    @BindView(R.id.btn2)
    Button btn2;
    @BindView(R.id.btn3)
    Button btn3;

    private String cid = "54990";
    private String openid = "oaMOUxA5Z6xIG5s0kRXcB-NgHMXE";
    private String tel = "13560445403";
    private String pwd = "ns198982";
    private String guid = "5b7b22d1-ab9a-4010-ba66-b400fd13adcd";
    private String tid = "";
    private String type = "0";
    private String subjectId = "2048";
    private static final String TAG = "TestMvpActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    protected TestPresenter createPresenter() {
        return new TestPresenter(this);
    }

    @Override
    public void showLoading()
    {
        showProgressDialog();
    }

    @Override
    public void hideLoading()
    {
        dismissProgressDialog();
    }

    @Override
    public void getTidSuccess(List<TidBean> tidList)
    {
        Log.i(TAG,"111");
        mvpPresenter.getTestModel(openid,tel,pwd,guid,tidList.get(0).getId(),type,subjectId);
    }

    @Override
    public void getTidFail(String msg) {

    }

    @Override
    public void getTestModelsuccess(List<TestModel> testModel)
    {
        Log.i(TAG,"111");
    }

    @Override
    public void getTestModeFail(String msg)
    {
        Log.i(TAG,"111");
    }

    @OnClick({R.id.btn, R.id.btn2, R.id.btn3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn:
                mvpPresenter.getTid(openid, tel, pwd, guid, cid, type, subjectId);
                break;
            case R.id.btn2:
                break;
            case R.id.btn3:
                break;
        }
    }
}
