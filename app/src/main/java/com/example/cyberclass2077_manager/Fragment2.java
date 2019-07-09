package com.example.cyberclass2077_manager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.cyberclass2077_manager.adapter.DynamicAdapter;
import com.example.cyberclass2077_manager.bean.DynamicBean;

import java.util.ArrayList;
import java.util.List;

public class Fragment2 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2_layout, container, false);


        ListView listView=view.findViewById(R.id.dyanamic_list);
        List<DynamicBean> dynamicBeanList=new ArrayList<>();
        for(int i=0;i<10;i++)
        {
            dynamicBeanList.add(new DynamicBean());
        }
        DynamicAdapter dynamicAdapter=new DynamicAdapter(view.getContext(),dynamicBeanList);
        listView.setAdapter(dynamicAdapter);
        return view;
    }
}
