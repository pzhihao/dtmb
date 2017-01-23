package com.stxpy.fragment.broadcast.child;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;

import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import me.yokeyword.fragmentation.SupportFragment;
import me.yokeyword.fragmentation.anim.DefaultHorizontalAnimator;
import me.yokeyword.fragmentation.anim.FragmentAnimator;
import com.stxpy.adapter.ProgramAdapter;
import com.stxpy.bean.PlayEditBean;
import com.stxpy.data.presenter.PlayEditListPresenter;
import com.stxpy.data.view.PlayEditListView;
import com.stxpy.dtmb.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProgramFragment extends SupportFragment implements PlayEditListView {

    private static final Logger l=Logger.getLogger("ProgramFragment");
    Button button;

    public ProgramFragment() {
        // Required empty public constructor
    }

    Animation slide_in_left, slide_out_right;
    PlayEditListPresenter playEditListPresenter;
    ProgressDialog progressDialog;
    DrawerLayout drawerLayout;
    ExpandableListView listView;
    List<PlayEditBean> listdata;
    ProgramAdapter programAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

        playEditListPresenter=new PlayEditListPresenter(this);
        playEditListPresenter.getPlayEditList("1","1","0");
        listdata=new ArrayList<>();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu,menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
                pop();
                break;
            case R.id.serach:
                //TODO 事件穿透到下面了
                drawerLayout.openDrawer(GravityCompat.END);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_program, container, false);
        listView= (ExpandableListView) view.findViewById(R.id.expandablelist);
        initToolbar(view);
        drawerLayout= (DrawerLayout) view.findViewById(R.id.program_drawer);
       programAdapter =new ProgramAdapter(listdata,_mActivity);
        listView.setAdapter(programAdapter);

        button= (Button) view.findViewById(R.id.click);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(_mActivity, "点击了", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
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

        toolbar.setTitle("节目编排");
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));

        t.setText("节目编排");

        _mActivity.setSupportActionBar(toolbar);
        //不显示标题
        _mActivity.getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    @Override
    protected FragmentAnimator onCreateFragmentAnimator() {
        return new DefaultHorizontalAnimator();
    }



    @Override
    public void getPlayEditListCompleted(List<PlayEditBean> list) {
        for (int i = 0; i <list.size() ; i++) {
            Log.v("Main",list.get(i).getName());
        }
        listdata.addAll(list);
        String s = list.toString();

        l.info("信息："+s);

    }

    @Override
    public void getPlayEditListError(String errmsg) {
        Log.v("Main","错误消息："+errmsg);
        Toast.makeText(_mActivity, "获取数据错误："+errmsg, Toast.LENGTH_SHORT).show();
        progressDialog.dismiss();
    }

    @Override
    public void getPlayEditListbefore() {
        Log.v("Main","请求之前");
        progressDialog=ProgressDialog.show(_mActivity,"","请稍后",true,false);
    }

    @Override
    public void getPlayEditListafter() {
        Log.v("Main","请求之后");
        progressDialog.dismiss();
        programAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onBackPressedSupport() {
        pop();
        return true;
    }
}
