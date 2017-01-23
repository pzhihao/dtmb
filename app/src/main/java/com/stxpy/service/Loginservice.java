package com.stxpy.service;

import com.stxpy.constant.URL;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2017/1/19.
 */

public interface Loginservice {
    @POST(URL.login)
    @FormUrlEncoded
    Flowable<String> getloginResult(@Field("LogName") String loginname, @Field("pw") String password);
}
