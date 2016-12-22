package stxpy.com.service;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import stxpy.com.bean.QualityInfo;

/**
 * Created by Administrator on 2016/12/10.
 */

public interface QualityService {

    @GET("basic/web/index.php?r=qualityinfo/get-json")
    Call<QualityInfo> listRepos();
}
