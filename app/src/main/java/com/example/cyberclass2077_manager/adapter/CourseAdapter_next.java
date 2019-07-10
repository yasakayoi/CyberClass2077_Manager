package com.example.cyberclass2077_manager.adapter;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cyberclass2077_manager.bean.CourseBean;
import com.example.cyberclass2077_manager.R;
import com.example.cyberclass2077_manager.controllers.CircleImageView;

import java.util.List;


public class CourseAdapter_next extends BaseAdapter {
    private Context context;
    private List<CourseBean> listDynamicBean;
    private LayoutInflater inflater;


    private String[] course_status_tag_content;

    public CourseAdapter_next(Context context, List<CourseBean> listDynamicBean)
    {
        this.context=context;
        this.listDynamicBean=listDynamicBean;
        this.inflater=LayoutInflater.from(context);
        course_status_tag_content = context.getResources().getStringArray(R.array.course_status_tag);//绑定tag_content
    }

    @Override
    public int getCount() {
        return listDynamicBean.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolderGroup viewHolderGroup;
        if(inflater==null)
        {
            inflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        }
        if(convertView==null)
        {
            convertView=inflater.inflate(R.layout.course_list_layout,null);
            viewHolderGroup=new ViewHolderGroup();
            viewHolderGroup.image_to_videoView=convertView.findViewById(R.id.course_video);
            viewHolderGroup.course_uploader=convertView.findViewById(R.id.course_uploader_image);
            viewHolderGroup.txt_video_title=convertView.findViewById(R.id.course_video_title);
            viewHolderGroup.txt_nick_name=convertView.findViewById(R.id.course_nick_name);
            viewHolderGroup.txt_remark=convertView.findViewById(R.id.course_remark);
            viewHolderGroup.spinner=convertView.findViewById(R.id.course_status_spinner);
            viewHolderGroup.view_seperate=convertView.findViewById(R.id.course_view_seperate);
            convertView.setTag(viewHolderGroup);
        }else
        {
            viewHolderGroup=(ViewHolderGroup)convertView.getTag();
        }

        switch (position){

            case 0:
                viewHolderGroup.course_uploader.setImageResource(R.drawable.lee);
                viewHolderGroup.image_to_videoView.setImageResource(R.drawable.course1);
                viewHolderGroup.txt_nick_name.setText("Lee");
                viewHolderGroup.txt_remark.setText("编程");
                viewHolderGroup.txt_video_title.setText("基于多特征值的数据预测");
                viewHolderGroup.spinner.setSelection(0);
                break;

            case 1:
                viewHolderGroup.course_uploader.setImageResource(R.drawable.lee);
                viewHolderGroup.image_to_videoView.setImageResource(R.drawable.course2);
                viewHolderGroup.txt_nick_name.setText("Lee");
                viewHolderGroup.txt_remark.setText("文化");
                viewHolderGroup.txt_video_title.setText("相关性并不代表因果性");
                viewHolderGroup.spinner.setSelection(1);
                break;

            case 2:
                viewHolderGroup.course_uploader.setImageResource(R.drawable.lee);
                viewHolderGroup.image_to_videoView.setImageResource(R.drawable.course3);
                viewHolderGroup.txt_nick_name.setText("Lee");
                viewHolderGroup.txt_remark.setText("编程");
                viewHolderGroup.txt_video_title.setText("数据结果噪音分析");
                viewHolderGroup.spinner.setSelection(1);
                break;
            default:
                break;
        }

        viewHolderGroup.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(context,course_status_tag_content[position],Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        return convertView;
    }

    class ViewHolderGroup{
        ImageView image_to_videoView;
        CircleImageView course_uploader;
        TextView txt_video_title;
        TextView txt_nick_name;
        TextView txt_remark;
        Spinner spinner;
        View view_seperate;
    }
}

