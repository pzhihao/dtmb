package stxpy.com.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import stxpy.com.dtmb.R;
import stxpy.com.myinterface.OnLeftMenuClickListener;

/**
 * Created by Administrator on 2016/12/22.
 */

public class BrodcastFragment extends baseFragment{

    private OnLeftMenuClickListener mListener;

    @Override
    public void OnCusCreateView(FrameLayout frameLayout, LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view=inflater.inflate(R.layout.fragment_my, container, false);

        frameLayout.addView(view);

    }

    @Override
    public void onLeftMenuClick() {
        super.onLeftMenuClick();
        mListener.onLeftMenuClick(this);
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
