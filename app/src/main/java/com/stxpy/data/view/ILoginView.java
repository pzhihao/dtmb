package com.stxpy.data.view;

import com.stxpy.bean.LoginResultBean;
import com.stxpy.bean.PlayEditBean;

import java.util.List;

/**
 * Created by Administrator on 2017/1/18.
 */

public interface ILoginView {
    void getLoginCompleted(String string);
    void getLoginError(String errmsg);
    void getLoginbefore();
    void getLoginafter();
}
