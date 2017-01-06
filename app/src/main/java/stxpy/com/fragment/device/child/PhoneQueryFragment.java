package stxpy.com.fragment.device.child;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import stxpy.com.dtmb.R;
import stxpy.com.fragment.base.baseContentFragment;

/**
 * Created by Administrator on 2017/1/6.
 */

public class PhoneQueryFragment extends baseContentFragment {

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        super.initData(savedInstanceState);
        setContentView(R.layout.phonequeryfragment);
    }

    @Override
    public void initView(View view) {
        super.initView(view);
        initToolbar(view,"终端查询");
    }

    @Override
    public void initEvent(View v) {
        super.initEvent(v);
    }
}
