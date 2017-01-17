package com.stxpy.service;

import retrofit2.Call;
import retrofit2.http.GET;
import com.stxpy.bean.QualityInfo;

/**
 * Created by Administrator on 2016/12/10.
 */

public interface QualityService {

    @GET("basic/web/index.php?r=qualityinfo/get-json")
    Call<QualityInfo> listRepos();
}
