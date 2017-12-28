package com.haifan.meihu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.haifan.meihu.base.BaseActivity;
import com.haifan.meihu.greendao.GreenDao;
import com.haifan.meihu.greendao.StudentMsgBean;
import com.haifan.meihu.greendao.StudentMsgBeanDao;
import com.haifan.meihu.retrofit.RetrofitCallback;
import com.haifan.meihu.model.MainModel;
import com.haifan.meihu.retrofit.ApiCallBack;
import com.haifan.meihu.R;

import org.greenrobot.greendao.query.Query;

import java.io.IOException;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.ResponseBody;
import retrofit2.Call;

/**
 * Created by youxue on 2017/12/13.
 */

public class TestActivity extends BaseActivity {

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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initToolBarAsHome("RxJava2");
    }

    @OnClick({R.id.btn, R.id.btn2, R.id.btn3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn:
                insert();
                break;
            case R.id.btn2:
                update();
                break;
            case R.id.btn3:
                query();
                break;
        }
    }

    /**
     * 增
     */
    private void insert()
    {
        try
        {
            StudentMsgBeanDao msgBeanDao = GreenDao.getInstance().getStudentMsgBeanDao();
            StudentMsgBean studentMsgBean = new StudentMsgBean();
            studentMsgBean.setName("zone3");
            studentMsgBean.setStudentNum("123456");
            msgBeanDao.insert(studentMsgBean);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * 删
     */
    private void delete()
    {
        StudentMsgBeanDao msgBeanDao = GreenDao.getInstance().getStudentMsgBeanDao();
        List<StudentMsgBean> list = msgBeanDao.queryBuilder().build().list();
        for (int i=0;i<list.size();i++)
        {
            if (i == 0)
            {
                msgBeanDao.deleteByKey(list.get(0).getId());//通过 Id 来删除数据
//                msgBeanDao.delete(list.get(0));//通过传入实体类的实例来删除数据
            }
        }
    }

    /**
     * 改
     */
    private void update()
    {
        StudentMsgBeanDao msgBeanDao = GreenDao.getInstance().getStudentMsgBeanDao();
        List<StudentMsgBean> list = msgBeanDao.queryBuilder().build().list();
        for (int i=0;i<list.size();i++)
        {
            if(i == 0)
            {
                list.get(0).setName("zone1111111111");
                msgBeanDao.update(list.get(0));
            }
        }
    }

    /**
     * 查
     */
    private void query()
    {
        StudentMsgBeanDao msgBeanDao = GreenDao.getInstance().getStudentMsgBeanDao();
//        List<StudentMsgBean> list = msgBeanDao.queryBuilder()
//                .offset(1)//偏移量，相当于 SQL 语句中的 skip
//                .limit(3)//只获取结果集的前 3 个数据
//                .orderAsc(StudentMsgBeanDao.Properties.StudentNum)//通过 StudentNum 这个属性进行正序排序
//                .where(StudentMsgBeanDao.Properties.Name.eq("zone"))//数据筛选，只获取 Name = "zone" 的数据。
//                .build()
//                .list();
//        if(null != list)
//        {
//
//        }
        Query<StudentMsgBean> query = msgBeanDao.queryBuilder().where(StudentMsgBeanDao.Properties.Name.eq("zone3")).build();
        List<StudentMsgBean> list = query.list();
        if(null != list)
        {

        }
    }

    private void getTid2()
    {
        showProgressDialog();
        addSubscription(apiStores().getTid2(openid, tel, pwd, guid, cid, type, subjectId), new ApiCallBack<ResponseBody>() {
            @Override
            public void onSuccess(ResponseBody model) {
                try {
                    String jsonStr = new String(model.bytes());
                    Log.i("11",jsonStr);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(String msg) {
                Log.i("11","11");
            }

            @Override
            public void onFinish() {
                dismissProgressDialog();
            }
        });
    }

    private void getTid()
    {
        showProgressDialog();
        Call<ResponseBody> call = apiStores().getTid(openid,tel,pwd,guid,cid,type,subjectId);
        call.enqueue(new RetrofitCallback<ResponseBody>() {
            @Override
            public void onSuccess(ResponseBody model) {
                try {
                    String jsonStr = new String(model.bytes());
                    Log.i("11",jsonStr);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(int code, String msg) {

            }

            @Override
            public void onThrowable(Throwable t) {

            }

            @Override
            public void onFinish() {
                dismissProgressDialog();
            }
        });
    }

    private void loadDataByRetrofit()
    {
        showProgressDialog();
        Call<ResponseBody> call = apiStores().loadDataByRetrofit(openid,tel,pwd,guid,subjectId,tid,type);
        call.enqueue(new RetrofitCallback<ResponseBody>() {
            @Override
            public void onSuccess(ResponseBody model) {
//                dataSuccess(model);
                Log.i("111",model.toString());
            }

            @Override
            public void onFailure(int code, String msg) {
                Log.i("11","11");
            }

            @Override
            public void onThrowable(Throwable t) {
                Log.i("11","11");
            }

            @Override
            public void onFinish() {
                Log.i("11","11");
                dismissProgressDialog();
            }
        });
    }

    private void dataSuccess(MainModel model) {
        MainModel.WeatherinfoBean weatherinfo = model.getWeatherinfo();
        String showData = getResources().getString(R.string.city) + weatherinfo.getCity()
                + getResources().getString(R.string.wd) + weatherinfo.getWD()
                + getResources().getString(R.string.ws) + weatherinfo.getWS()
                + getResources().getString(R.string.time) + weatherinfo.getTime();
        tv.setText(showData);
    }
}
