package com.stxpy.service;

import java.util.List;

import io.reactivex.Flowable;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import com.stxpy.bean.HttpBean;
import com.stxpy.bean.LoginResultBean;
import com.stxpy.bean.PlayEditBean;
import com.stxpy.constant.URL;

/**
 * Created by Administrator on 2017/1/5.
 */

public interface PlayEditService {

    @POST(URL.zhuanboList)
    @FormUrlEncoded
    Flowable<List<PlayEditBean>> getplayeditlist(@Field("OrgID") String OrgID, @Field("SelctOrgID") String SelctOrgID, @Field("State") String State);

}
