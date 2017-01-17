package com.stxpy.data.view;

import java.util.List;

import com.stxpy.bean.PlayEditBean;

/**
 * Created by Administrator on 2017/1/5.
 */

public interface PlayEditListView {
    void getPlayEditListCompleted(List<PlayEditBean> list);
    void getPlayEditListError(String errmsg);
    void getPlayEditListbefore();
    void getPlayEditListafter();
}
