package stxpy.com.data.view;

import java.util.List;

import stxpy.com.bean.PlayEditBean;

/**
 * Created by Administrator on 2017/1/5.
 */

public interface PlayEditListView {
    void getPlayEditListCompleted(List<PlayEditBean> list);
    void getPlayEditListError(String errmsg);
    void getPlayEditListbefore();
    void getPlayEditListafter();
}
