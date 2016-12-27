package stxpy.com.fragment.broadcast;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.yokeyword.fragmentation.SupportFragment;
import stxpy.com.dtmb.R;
import stxpy.com.fragment.broadcast.child.BroadcastHomeFragment;

/**
 * Created by Administrator on 2016/12/22.
 */

public class BrodcastFragment extends SupportFragment {





    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.fragment_my, container, false);
        return view;
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);

        loadRootFragment(R.id.fl_brodcast_container,new BroadcastHomeFragment());

       // initEvent(view);
    }

}
