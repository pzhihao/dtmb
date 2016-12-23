package stxpy.com.dtmb;

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
import stxpy.com.fragment.BrodcastFragment;
import stxpy.com.fragment.MonitorFragment;
import stxpy.com.fragment.SystemManagerFragment;
import stxpy.com.fragment.device_managerFragment;
import stxpy.com.myinterface.OnLeftMenuClickListener;

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

    SupportFragment currentfragment;
    int index=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                activityMain.closeDrawers();
                Toast.makeText(MainActivity.this, "点击的数据是："+adapterView.getAdapter().getItem(i), Toast.LENGTH_SHORT).show();

                showHideFragment(mFragments[i],mFragments[index]);
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

                loadMultipleRootFragment(R.id.content_frame,0,mFragments[0],mFragments[1],mFragments[2],mFragments[3]);


        }else {
            mFragments[0]=findFragment(BrodcastFragment.class);
            mFragments[1]=findFragment(device_managerFragment.class);
            mFragments[2]=findFragment(MonitorFragment.class);
            mFragments[3]=findFragment(SystemManagerFragment.class);
        }

    }


    //ToolBar的菜单键点击

    @Override
    public void onLeftMenuClick(SupportFragment supportFragment) {
        activityMain.openDrawer(GravityCompat.START);
        currentfragment=supportFragment;
    }
}
