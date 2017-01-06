package stxpy.com.fragment.broadcast.child;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import stxpy.com.dtmb.R;
import stxpy.com.fragment.base.baseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class BroadcastHomeFragment extends baseFragment {

    View view;

    public BroadcastHomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_broadcast_home, container, false);

        Toolbar toolbar= (Toolbar) view.findViewById(R.id.gk_toolbar);
        toolbar.setTitle("广播管控");
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
        LinearLayout word= (LinearLayout) view.findViewById(R.id.wordlive);
        LinearLayout program= (LinearLayout) view.findViewById(R.id.programbp);
        LinearLayout testControl= (LinearLayout) view.findViewById(R.id.testControl);

        View.OnClickListener listener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.wordlive:
                        start(new WordLiveFragment());
                        break;
                    case R.id.programbp:
                        start(new ProgramFragment());
                        break;
                    case R.id.testControl:
                        start(TestControlFragment.newInstance("第一","第二"));
                        break;
                }
            }
        };

        word.setOnClickListener(listener);
        program.setOnClickListener(listener);
        testControl.setOnClickListener(listener);

    }
}
