package stxpy.com.fragment.system.child;


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
public class SystemmanagerHomeFragment extends baseFragment {


    public SystemmanagerHomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.fragment_system_manager,container,false);
       Toolbar toolbar= (Toolbar) view.findViewById(R.id.gk_toolbar);
        initToolBarNav(toolbar);
        return view;
    }

}
