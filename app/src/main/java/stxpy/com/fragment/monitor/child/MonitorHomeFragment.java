package stxpy.com.fragment.monitor.child;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import stxpy.com.dtmb.R;
import stxpy.com.fragment.base.baseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class MonitorHomeFragment extends baseFragment {


    public MonitorHomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,

                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_monitor,container,false);
        Toolbar toolbar= (Toolbar) view.findViewById(R.id.gk_toolbar);
        toolbar.setTitle("监控查询");
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
        initToolBarNav(toolbar);

        return view;
    }

}
