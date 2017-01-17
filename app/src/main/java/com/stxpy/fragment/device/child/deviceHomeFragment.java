package com.stxpy.fragment.device.child;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.stxpy.dtmb.R;
import com.stxpy.fragment.base.baseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class deviceHomeFragment extends baseFragment {

    View view=null;

    public deviceHomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_device_home, container, false);
        Toolbar toolbar= (Toolbar) view.findViewById(R.id.gk_toolbar);
        toolbar.setTitle("终端管理");
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
        initToolBarNav(toolbar);
        return view;
    }




    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        initEvent(view);
    }

    private void initEvent(View view) {

        Log.v("Main","执行了");
        LinearLayout l= (LinearLayout) view.findViewById(R.id.phone_query);
        LinearLayout de= (LinearLayout) view.findViewById(R.id.device_position);
        LinearLayout status= (LinearLayout) view.findViewById(R.id.device_status_query);

        View.OnClickListener li=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.phone_query:
                       start(new DeviceQueryFragment());
                        break;
                    case R.id.device_position:
                        start(new DevicePositionFragment());
                        break;
                    case R.id.device_status_query:
                        start(new DeviceStatusQueryFragment());
                        break;
                }
            }
        };


        de.setOnClickListener(li);
        status.setOnClickListener(li);
        l.setOnClickListener(li);

    }
}
