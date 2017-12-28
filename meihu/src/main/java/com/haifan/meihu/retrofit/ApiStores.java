package com.haifan.meihu.retrofit;

import com.haifan.meihu.model.MainModel;
import com.haifan.meihu.model.TidBean;
import com.haifan.meihu.model.testmodel.TestModel;

import java.util.List;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by youxue on 2017/12/11.
 */

public interface ApiStores {

    //baseUrl
    String API_SERVER_URL = "http://app.yatiku.com/app/";

    @GET("gettestmodelishtml")
    Call<ResponseBody> loadDataByRetrofit(@Query("openid") String openid,@Query("tel") String tel
            ,@Query("pwd") String pwd,@Query("guid") String guid,@Query("subjectId") String subjectId,@Query("tid") String tid,@Query("type") String type);

    @GET("adat/sk/{cityId}.html")
    Observable<MainModel> loadDataByRetrofit2(@Query("cityId") String cityId);

    @GET("gettidstate")
    Call<ResponseBody> getTid(@Query("openid") String openid,@Query("tel") String tel
            ,@Query("pwd") String pwd,@Query("guid") String guid,@Query("cid") String cid,@Query("type") String type,@Query("subjectId") String subjectId);

    @GET("gettidstate")
    Observable<List<TidBean>> getTid2(@Query("openid") String openid, @Query("tel") String tel
            , @Query("pwd") String pwd, @Query("guid") String guid, @Query("cid") String cid, @Query("type") String type, @Query("subjectId") String subjectId);

    @GET("gettestmodelishtml")
    Observable<List<TestModel>> getTestModel(@Query("openid") String openid
            , @Query("tel") String tel, @Query("pwd") String pwd, @Query("guid") String guid
            , @Query("tid") String tid, @Query("type") String type, @Query("subjectId") String subjectId);
}
