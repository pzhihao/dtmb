package stxpy.com.fragment.broadcast.child;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import me.yokeyword.fragmentation.SupportFragment;
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_word_live, container, false);
        initToolbar(view);



        EditText editText= (EditText) view.findViewById(R.id.et_content);
        editText.setHorizontallyScrolling(false);

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

    public void showDialog(final TextView v){
        new AlertDialog.Builder(_mActivity)
                .setTitle("选择播放次数")
                .setIcon(android.R.drawable.ic_dialog_info)
                .setSingleChoiceItems(new String[]{"1", "2", "3"}, playtimeindex, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        playtimeindex=which;
                        v.setText(String.valueOf(playtimeindex+1));
                    }
                }).setNegativeButton("取消",null)
                .setPositiveButton("确定", null)
                .show();
    }

    private void initToolbar(View v) {
        Toolbar toolbar= (Toolbar)v.findViewById(R.id.gk_toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_action_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop();
            }
        });
       TextView t= (TextView) toolbar.findViewById(R.id.toolbar_title);
        t.setText("文字直播");
    }


    //拦截按键，弹栈弹出fragment模拟后退
    @Override
    public boolean onBackPressedSupport() {
        pop();
        return true;
    }
}
