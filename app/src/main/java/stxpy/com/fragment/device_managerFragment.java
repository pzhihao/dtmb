package stxpy.com.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import stxpy.com.dtmb.R;
import stxpy.com.myinterface.OnLeftMenuClickListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class device_managerFragment extends baseFragment {


    private OnLeftMenuClickListener mListener;


    @Override
    public void OnCusCreateView(FrameLayout frameLayout, LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        super.OnCusCreateView(frameLayout, inflater, container, savedInstanceState);
        View view=inflater.inflate(R.layout.fragment_device_manager, container, false);
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
