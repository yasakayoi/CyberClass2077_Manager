package com.example.cyberclass2077_manager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.cyberclass2077_manager.adapter.CourseAdapter;
import com.example.cyberclass2077_manager.adapter.MutiChoiceAdapter;
import com.example.cyberclass2077_manager.bean.CourseBean;

import java.util.ArrayList;
import java.util.List;


public class Fragment1 extends Fragment {


    MutiChoiceDialog dialogFragment2;
    private TextView selected_tag;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment1_layout, container, false);
        selected_tag=(TextView)view.findViewById(R.id.search_tag);
        selected_tag.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                //多选对话框
                dialogFragment2.show(getFragmentManager(),"dialog");

            }

        });

        //初始化list
        ListView listView=view.findViewById(R.id.course_list);
        List<CourseBean> courseBeanList=new ArrayList<>();
        for(int i=0;i<3;i++)
        {
            courseBeanList.add(new CourseBean());
        }

        CourseAdapter courseAdapter=new CourseAdapter(view.getContext(),courseBeanList);
        listView.setAdapter(courseAdapter);






        return view;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dialogFragment2 =  new MutiChoiceDialog();
    }

    //多选对话框
    static  public class MutiChoiceDialog extends DialogFragment {


        private RecyclerView recyclerView ;
        private TextView sure_action ,cancel_action;
        /**
         * 记录是否被选中
         */
        private SparseArray<Boolean> sparseArray =new SparseArray();//保存该位置是否被选中的信息，true为选中，false为未选中
        private List<Integer> listPosition =new ArrayList<>();//int型的list，保存所以选中的选项的编号

        //暂存状态值
        private SparseArray<Boolean> save_sparseArray ;
        private List<Integer> save_listPosition  =new ArrayList<>();

        /**
         * 回调给界面
         */
        interface OnSureListener
        {
            void onSureClick(List<Integer> list);
        }
        private OnSureListener onSureListener ;

        public void setOnSureListener(OnSureListener onSureListener) {
            this.onSureListener = onSureListener;
        }
        //        返回标签list,                                                             调用getList()函数，获取用户选择的标签，返回标签的无序列表，记得判断是否为空哦
        public List<Integer> getList(){
            return  listPosition;
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        @Override
        public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.multiple_selection_dialog_layout,container,false) ;
            initId(view);
            return view ;
        }

        private void initId(View view)
        {
            //暂存状态值
            save_sparseArray =sparseArray.clone();
            save_listPosition.addAll(listPosition);
//                绑定控件
            recyclerView = (RecyclerView)view.findViewById(R.id.multiply_selection_recycler_view);
            sure_action = (TextView) view.findViewById(R.id.multiply_selection_sure) ;
            cancel_action = (TextView)view.findViewById(R.id.multiply_selection_cancel);

            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            final MutiChoiceAdapter mutiChoiceAdapter = new MutiChoiceAdapter(getContext());
            recyclerView.setAdapter(mutiChoiceAdapter);
//                初始化adapter
            mutiChoiceAdapter.setSparseArray(sparseArray);
//            多选框的点击监听器
            mutiChoiceAdapter.setOnItemClikListener(new MutiChoiceAdapter.OnItemClikListener() {
                @Override
                public void onItemClick(MutiChoiceAdapter.MyViewHolder viewHolder, int position) {
                    if(sparseArray.get(position)!=null) {
                        if(sparseArray.get(position))
                        {
                            listPosition.remove(listPosition.indexOf(position));
                        }else
                        {
                            listPosition.add(position);
                        }
                        sparseArray.put(position, !sparseArray.get(position));
                        viewHolder.imageView.setSelected(sparseArray.get(position));

                    }else
                    {
                        sparseArray.put(position, true);
                        viewHolder.imageView.setSelected(true);
                        listPosition.add(position);
                    }
//                    更新adapter
                    mutiChoiceAdapter.setSparseArray(sparseArray);

                }
            });
            //确认按钮的监听器
            sure_action.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(onSureListener != null)
                    {
                        onSureListener.onSureClick(listPosition);
                    }
                    dismiss();
                }
            });
            //取消按钮的监听器
            cancel_action.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //将列表状态回退至修改前的版本
                    listPosition.clear();
                    listPosition.addAll(save_listPosition);
                    sparseArray =save_sparseArray.clone();
                    dismiss();

                }
            });
        }
    }


}

