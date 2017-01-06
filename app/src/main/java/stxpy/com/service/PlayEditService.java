package stxpy.com.service;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;
import stxpy.com.bean.PlayEditBean;
import stxpy.com.constant.URL;

/**
 * Created by Administrator on 2017/1/5.
 */

public interface PlayEditService {
    @POST(URL.zhuanboList)
    @FormUrlEncoded
    Flowable<List<PlayEditBean>> getplayeditlist(@Field("OrgID") String OrgID, @Field("SelctOrgID") String SelctOrgID, @Field("State") String State);
}
