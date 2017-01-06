package stxpy.com.fragment.broadcast.child;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import me.yokeyword.fragmentation.SupportFragment;
import me.yokeyword.fragmentation.anim.DefaultHorizontalAnimator;
import me.yokeyword.fragmentation.anim.FragmentAnimator;
import stxpy.com.dtmb.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class WordLiveFragment extends SupportFragment {

    private int playtimeindex=0;



    private static final String TAG = "WordLiveFragment";

    public WordLiveFragment() {
        // Required empty public

    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_word_live, container, false);
        initToolbar(view);



        EditText editText= (EditText) view.findViewById(R.id.et_content);
        editText.setHorizontallyScrolling(false);
        EditText town_et= (EditText) view.findViewById(R.id.my_town);
        town_et.setClickable(true);
        town_et.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView=new TextView(_mActivity);
                textView.setText("哈哈");
                LayoutInflater from = LayoutInflater.from(_mActivity);
                View inflate = from.inflate(R.layout.dialog_listview, container, false);

                AlertDialog dialog=new AlertDialog.Builder(_mActivity).setTitle("选择乡镇").setPositiveButton("确定",null).create();



                dialog.setView(inflate);

                dialog.show();

            }
        });

        initData(view);

        return view;
    }

    private void initData(View view) {
        String[] stringArray = getResources().getStringArray(R.array.palytime);
        String[] playlevel=new String[9];

        for (int i=0;i<9;i++){
            playlevel[i]=String.valueOf(i+1);
        }


        Spinner spinner = (Spinner) view.findViewById(R.id.playtime_sp);
        ArrayAdapter arrayAdapter=new ArrayAdapter(_mActivity,R.layout.sing_spinner,stringArray);

        Spinner playlevel_sp= (Spinner) view.findViewById(R.id.playtime_level);
        ArrayAdapter pl_ad=new ArrayAdapter(_mActivity,android.R.layout.simple_spinner_item,playlevel);
        playlevel_sp.setAdapter(pl_ad);

        spinner.setAdapter(arrayAdapter);
    }



    private void initToolbar(View v) {
        Toolbar toolbar= (Toolbar)v.findViewById(R.id.gk_toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_action_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop();
                hideSoftInput();
            }
        });
       TextView t= (TextView) toolbar.findViewById(R.id.toolbar_title);
        t.setText("文字直播");
    }

    @Override
    protected FragmentAnimator onCreateFragmentAnimator() {
        return new DefaultHorizontalAnimator();
    }

    //拦截按键，弹栈弹出fragment模拟后退
    @Override
    public boolean onBackPressedSupport() {
        pop();
        return true;
    }
}
