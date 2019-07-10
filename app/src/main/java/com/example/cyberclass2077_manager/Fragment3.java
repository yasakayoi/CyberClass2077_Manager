package com.example.cyberclass2077_manager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Fragment3 extends Fragment {

    private TextView to_check_course_list;
    private TextView to_banned_user_list;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment3_layout, container, false);
        initWidget(view);

        return view;
    }

    void initWidget(View view){
        to_check_course_list =(TextView)view.findViewById(R.id.check_course_list);//跳转到审核课程列表的控件
        to_banned_user_list =(TextView)view.findViewById(R.id.banned_user_list);//跳转到禁言用户列表的控件


        to_check_course_list.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Fragment3CheckCourselistActivity.class);   //跳转到新界面
                startActivity(intent);
            }
        });

        to_banned_user_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Fragment3CheckAccountlistActivity.class);   //跳转到新界面
                startActivity(intent);
            }
        });

    }
}