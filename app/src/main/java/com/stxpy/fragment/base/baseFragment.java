package com.stxpy.fragment.base;


import android.content.Context;
import android.support.v7.widget.Toolbar;
import android.view.View;

import me.yokeyword.fragmentation.SupportFragment;
import com.stxpy.dtmb.R;
import com.stxpy.myinterface.OnLeftMenuClickListener;

/**
 *Home页Fragment的基类
 */
public class baseFragment extends SupportFragment{

    private OnLeftMenuClickListener mListener;

    protected void  initToolBarNav(Toolbar toolbar){
        toolbar.setNavigationIcon(R.drawable.ic_action_name);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLeftMenuClick();
            }
        });
    }



    public void onLeftMenuClick() {
        mListener.onLeftMenuClick();
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnLeftMenuClickListener) {
            mListener = (OnLeftMenuClickListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}
