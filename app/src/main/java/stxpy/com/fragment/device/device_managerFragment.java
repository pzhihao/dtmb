package stxpy.com.fragment.device;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import me.yokeyword.fragmentation.SupportFragment;
import stxpy.com.dtmb.R;
import stxpy.com.fragment.broadcast.child.BroadcastHomeFragment;
import stxpy.com.fragment.device.child.deviceHomeFragment;
import stxpy.com.myinterface.OnLeftMenuClickListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class device_managerFragment extends SupportFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_my, container, false);
        return view;
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        loadRootFragment(R.id.fl_brodcast_container,new deviceHomeFragment());
    }
}
