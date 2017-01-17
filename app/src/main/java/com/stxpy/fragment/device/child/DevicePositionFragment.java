package com.stxpy.fragment.device.child;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.stxpy.dtmb.R;
import com.stxpy.fragment.base.baseContentFragment;

/**
 * Created by Administrator on 2017/1/9.
 */

public class DevicePositionFragment extends baseContentFragment {
    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        super.initData(savedInstanceState);
        setContentView(R.layout.devicepositionfragment);
    }

    @Override
    public void initView(View view) {
        super.initView(view);
        initToolbar(view,"终端定位");
    }

    @Override
    public void initEvent(View v) {
        super.initEvent(v);
    }
}
