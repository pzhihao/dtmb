package com.stxpy.dtmb;

import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.yokeyword.fragmentation.SupportActivity;
import me.yokeyword.fragmentation.SupportFragment;
import com.stxpy.fragment.broadcast.BrodcastFragment;
import com.stxpy.fragment.device.device_managerFragment;
import com.stxpy.fragment.monitor.MonitorFragment;
import com.stxpy.fragment.system.SystemManagerFragment;
import com.stxpy.myinterface.OnLeftMenuClickListener;

public class MainActivity extends SupportActivity implements OnLeftMenuClickListener {

    @BindView(R.id.list_menu)
    ListView listMenu;
    @BindView(R.id.left)
    LinearLayout left;
    @BindView(R.id.activity_main)
    DrawerLayout activityMain;

    String[] stringArray=null;
    ArrayAdapter arrayAdapter;
    SupportFragment mFragments[]=new SupportFragment[4];

    int index=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState!=null){
            index=savedInstanceState.getInt("index");
        }
        ButterKnife.bind(this);
        initDrawMenu();
        initFragment(savedInstanceState);
    }

    private void initDrawMenu() {
        stringArray= getResources().getStringArray(R.array.left_menu);
        arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,stringArray);
        listMenu.setAdapter(arrayAdapter);
        listMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "点击的数据是："+adapterView.getAdapter().getItem(i), Toast.LENGTH_SHORT).show();
                showHideFragment(mFragments[i],mFragments[index]);
                activityMain.closeDrawers();
                index=i;
            }
        });
    }




    private void initFragment(Bundle savedInstanceState ) {

        if (savedInstanceState == null){
                mFragments[0]=new BrodcastFragment();
               mFragments[1]=new device_managerFragment();
                mFragments[2]=new MonitorFragment();
                  mFragments[3]=new SystemManagerFragment();
                loadMultipleRootFragment(R.id.content_frame,index,mFragments[0],mFragments[1],mFragments[2],mFragments[3]);
        }else {

            mFragments[0]=findFragment(BrodcastFragment.class);
            mFragments[1]=findFragment(device_managerFragment.class);
            mFragments[2]=findFragment(MonitorFragment.class);
            mFragments[3]=findFragment(SystemManagerFragment.class);
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("index",index);
    }

    //ToolBar的菜单键点击

    @Override
    public void onLeftMenuClick() {
        activityMain.openDrawer(GravityCompat.START);
    }
}
