package com.example.cyberclass2077_manager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.cyberclass2077_manager.adapter.UserListAdapter;
import com.example.cyberclass2077_manager.bean.UserListBean;

import java.util.ArrayList;
import java.util.List;

public class Fragment3CheckAccountlistActivity extends AppCompatActivity {
    private ImageButton img_to_backUserlayout;
    private ListView listView_followee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment3_followeelist_layout);
        initWidget();
    }
    void initWidget(){
        listView_followee = (ListView)findViewById(R.id.id_followee_list);
        List<UserListBean> userListBeansList = new ArrayList<>();
        for(int i=0;i<1;i++)
        {
            UserListBean userListBean=new UserListBean();
            userListBeansList.add(userListBean);
        }

        listView_followee.setAdapter(new UserListAdapter(Fragment3CheckAccountlistActivity.this, userListBeansList));

        //跳转到个人主页
        img_to_backUserlayout = findViewById(R.id.img_followee_back_button);
        img_to_backUserlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Fragment3CheckAccountlistActivity.this,MainActivity.class);
                intent.putExtra("fragment",2);
                startActivity(intent);
                finish();
            }
        });
    }
}

