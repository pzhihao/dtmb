package com.stxpy.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.List;


import com.stxpy.bean.PlayEditBean;
import com.stxpy.dtmb.R;

/**
 * Created by Administrator on 2017/1/6.
 */

public class ProgramAdapter extends BaseExpandableListAdapter {

    private List<PlayEditBean> listview;
    private Context context;

    public ProgramAdapter(List<PlayEditBean> listview, Context context) {
        this.listview = listview;
        this.context = context;
        Log.v("main","创建对象ProgramAdapter");
    }



    //父项的数量
    @Override
    public int getGroupCount() {

        return listview.size();
    }

    //子项的数量
    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    //获得某个父项
    @Override
    public Object getGroup(int groupPosition) {
        return listview.get(groupPosition);
    }

    //获得某个父项的某个子项
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return listview.get(groupPosition);
    }

    //获得某个父项的id
    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    //获得父项的某个子项的id
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    //返回父视图
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        GroupHolder groupHolder=null;
        if (convertView == null){
            groupHolder=new GroupHolder();
            convertView=LayoutInflater.from(context).inflate(R.layout.program_parent,parent,false);
            groupHolder.textView= (TextView) convertView.findViewById(R.id.program_parent);
            convertView.setTag(groupHolder);
        }else {
            groupHolder= (GroupHolder) convertView.getTag();
        }


        groupHolder.textView.setText(listview.get(groupPosition).getName());



        return convertView;
    }

    //返回父视图下的某个子视图
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        ChildHolder childHolder=null;
        if (convertView == null){
            childHolder=new ChildHolder();
            convertView=LayoutInflater.from(context).inflate(R.layout.program_child,parent,false);
            childHolder.textView= (TextView) convertView.findViewById(R.id.program_name);
            childHolder.danwei= (TextView) convertView.findViewById(R.id.program_danwei);
            childHolder.user= (TextView) convertView.findViewById(R.id.program_user);
            childHolder.program_name= (TextView) convertView.findViewById(R.id.program_name2);
            childHolder.zhouqi= (TextView) convertView.findViewById(R.id.program_zhouqi);
            childHolder.startTime= (TextView) convertView.findViewById(R.id.program_startTime);
            childHolder.endTime= (TextView) convertView.findViewById(R.id.program_endTime);
            childHolder.status= (TextView) convertView.findViewById(R.id.program_status);
            convertView.setTag(childHolder);
        }else {
            childHolder= (ChildHolder) convertView.getTag();
        }
        childHolder.textView.setText(listview.get(groupPosition).getProgramName());
        childHolder.danwei.setText(listview.get(groupPosition).getOrgname());
        childHolder.user.setText(listview.get(groupPosition).getLogName());
        childHolder.program_name.setText(listview.get(groupPosition).getProgramName());
        childHolder.zhouqi.setText(listview.get(groupPosition).getPlayTypeName());
        childHolder.startTime.setText(listview.get(groupPosition).getStarTime());
        childHolder.endTime.setText(listview.get(groupPosition).getEndTime());
        childHolder.status.setText(listview.get(groupPosition).getState());


        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    class GroupHolder{
        public TextView textView;
    }
    class ChildHolder{
        public TextView textView;
        public TextView danwei;
        public TextView user;
        TextView program_name;
        TextView zhouqi;
        TextView startTime;
        TextView endTime;
        TextView status;
    }
}

