package com.stxpy.fragment.monitor;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.yokeyword.fragmentation.SupportFragment;
import com.stxpy.dtmb.R;
import com.stxpy.fragment.monitor.child.MonitorHomeFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class MonitorFragment extends SupportFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_my, container, false);
        return view;
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        loadRootFragment(R.id.fl_brodcast_container,new MonitorHomeFragment());
    }

}
