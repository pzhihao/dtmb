package com.stxpy.fragment.system;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.yokeyword.fragmentation.SupportFragment;
import com.stxpy.dtmb.R;
import com.stxpy.fragment.system.child.SystemmanagerHomeFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class SystemManagerFragment extends SupportFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_my, container, false);

        return inflate;
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loadRootFragment(R.id.fl_brodcast_container,new SystemmanagerHomeFragment());

    }
}
