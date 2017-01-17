package com.stxpy.fragment.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import me.yokeyword.fragmentation.SupportFragment;
import me.yokeyword.fragmentation.anim.DefaultHorizontalAnimator;
import me.yokeyword.fragmentation.anim.FragmentAnimator;
import com.stxpy.dtmb.R;

/**
 * Created by Administrator on 2017/1/6.
 */

public class baseContentFragment extends SupportFragment  {



    int Resid;
    View inflate;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData(savedInstanceState);
    }

    public void setContentView(int Resid) {
        this.Resid=Resid;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){

        if (Resid == 0){
            throw new NullPointerException("资源id不能为空,请调用setContentView设置");
        }

        inflate= LayoutInflater.from(_mActivity).inflate(Resid, container, false);

        initView(inflate);

        return inflate;
    }

    //在懒加载的方法中初始化事件
    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        initEvent(inflate);
    }

    public void initEvent(View v) {

    }

    //弹栈的方式模拟Activity返回，并隐藏键盘
    @Override
    public boolean onBackPressedSupport() {
        pop();
        hideSoftInput();
        return true;
    }


    //初始化头部
    public void initToolbar(View view,CharSequence charSequence){
        Toolbar toolbar= (Toolbar)view.findViewById(R.id.gk_toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_action_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop();
            }
        });
        TextView t= (TextView) toolbar.findViewById(R.id.toolbar_title);
        t.setText(charSequence);
    }
    public void initData(@Nullable Bundle savedInstanceState){

    }
    public void initView(View view){

    }

    //默认的横向切换特效
    @Override
    protected FragmentAnimator onCreateFragmentAnimator() {
        return new DefaultHorizontalAnimator();
    }
}
