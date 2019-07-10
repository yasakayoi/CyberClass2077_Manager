package com.example.cyberclass2077_manager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.cyberclass2077_manager.adapter.CourseAdapter;
import com.example.cyberclass2077_manager.bean.CourseBean;

import java.util.ArrayList;
import java.util.List;

public class Fragment3CheckCourselistActivity extends AppCompatActivity {

    private ImageButton img_to_backUserlayout;
    private ListView listView_course;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment3_check_courselist_layout);
        initWidget();
    }

    void initWidget(){
        listView_course=(ListView) findViewById(R.id.id_check_course_list);
        List<CourseBean> courseBeanList=new ArrayList<>();
        for(int i=0;i<1;i++)
        {
            courseBeanList.add(new CourseBean());
        }

        CourseAdapter courseAdapter=new CourseAdapter(Fragment3CheckCourselistActivity.this,courseBeanList);
        listView_course.setAdapter(courseAdapter);


        //跳转到用户个人主页
        img_to_backUserlayout = findViewById(R.id.check_course_back_button);
        img_to_backUserlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Fragment3CheckCourselistActivity.this,MainActivity.class);
                intent.putExtra("fragment",2);
                startActivity(intent);
                finish();
            }
        });
    }

}
