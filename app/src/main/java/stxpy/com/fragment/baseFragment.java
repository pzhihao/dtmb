package stxpy.com.fragment;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import me.yokeyword.fragmentation.SupportFragment;
import stxpy.com.dtmb.R;
import stxpy.com.myinterface.OnLeftMenuClickListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class baseFragment extends SupportFragment{



    public baseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_base, container, false);

        Toolbar toolbar= (Toolbar) view.findViewById(R.id.gk_toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLeftMenuClick();
            }
        });

        FrameLayout frameLayout= (FrameLayout) view.findViewById(R.id.mycontent_frame);

        OnCusCreateView(frameLayout,inflater,container,savedInstanceState);

        return view;
    }

    public void OnCusCreateView(FrameLayout frameLayout,LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState){

    }

    public void onLeftMenuClick(){

    }

}
