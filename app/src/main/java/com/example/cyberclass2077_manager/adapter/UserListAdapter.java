package com.example.cyberclass2077_manager.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cyberclass2077_manager.ChangeUserInfoActivity;
import com.example.cyberclass2077_manager.R;
import com.example.cyberclass2077_manager.bean.UserListBean;
import com.example.cyberclass2077_manager.controllers.CircleImageView;

import java.util.List;

public class UserListAdapter extends BaseAdapter {
    private Context context;
    private List<UserListBean> listDynamicBean;
    private LayoutInflater inflater;

    public UserListAdapter(Context context, List<UserListBean> listDynamicBean)
    {
        this.context=context;
        this.listDynamicBean=listDynamicBean;
        this.inflater=LayoutInflater.from(context);
    }

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
            convertView=inflater.inflate(R.layout.followee_list_layout,null);
            viewHolderGroup=new ViewHolderGroup();
            viewHolderGroup.followee_image = convertView.findViewById(R.id.followee_list_user_image);
            viewHolderGroup.followee_nickname = convertView.findViewById(R.id.followee_list_nickname);
            viewHolderGroup.followee_sex = convertView.findViewById(R.id.followee_list_user_sex);
            viewHolderGroup.followee_isbanned = convertView.findViewById(R.id.followee_list_is_banned);
            convertView.setTag(viewHolderGroup);
        }else
        {
            viewHolderGroup=(ViewHolderGroup)convertView.getTag();
        }

        switch (position)
        {
            case 0:
                viewHolderGroup.followee_image.setImageResource(R.drawable.lee);
                viewHolderGroup.followee_nickname.setText("Lee");
                viewHolderGroup.followee_sex.setImageResource(R.drawable.male);
                viewHolderGroup.followee_isbanned.setText("禁言");
                break;
            case 1:
                viewHolderGroup.followee_image.setImageResource(R.drawable.lee);
                viewHolderGroup.followee_nickname.setText("Lee2");
                viewHolderGroup.followee_sex.setImageResource(R.drawable.circle);
                viewHolderGroup.followee_isbanned.setText("禁言");
                break;
            case 2:
                viewHolderGroup.followee_image.setImageResource(R.drawable.lee);
                viewHolderGroup.followee_nickname.setText("Lee3");
                viewHolderGroup.followee_sex.setImageResource(R.drawable.male);
                viewHolderGroup.followee_isbanned.setText("禁言");
                break;
            default:
                break;
        }

        viewHolderGroup.followee_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ChangeUserInfoActivity.class);
                intent.putExtra("back_fragment",2);
                intent.putExtra("place_new",0);
                context.startActivity(intent);
            }
        });



        return convertView;
    }


    class ViewHolderGroup{
        CircleImageView followee_image;
        TextView followee_nickname;
        ImageView followee_sex;
        TextView followee_isbanned;
    }
}
