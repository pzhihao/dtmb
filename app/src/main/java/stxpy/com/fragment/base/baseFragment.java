package stxpy.com.fragment.base;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import me.yokeyword.fragmentation.SupportFragment;
import stxpy.com.dtmb.R;
import stxpy.com.myinterface.OnLeftMenuClickListener;

/**
 * A simple {@link Fragment} subclass.
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
