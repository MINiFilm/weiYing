package com.weiying.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import com.weiying.R;
import com.weiying.adapter.GridViewAdapter;
import com.weiying.bean.DetailsBean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 1.类的用途
 * 2.@author棒棒糖：赵姗杉
 * 3.@date2017/12/16  10：06
 */

public class DescribeFragment extends Fragment {
    View view;
    @Bind(R.id.jian_director)
    TextView jianDirector;
    @Bind(R.id.jian_actors)
    TextView jianActors;
    @Bind(R.id.jian_description)
    TextView jianDescription;
    @Bind(R.id.jian_grid)
    GridView jianGrid;

    private DetailsBean.RetBean ret;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //用这个方法来获取传递过来的数据
            Bundle bundle = getArguments();
            ret = (DetailsBean.RetBean) bundle.getSerializable("ret");
            Log.e("Fragment", ret.getTitle());
        } else {
            Log.e("Fragment", "getArguments()是个空");
        }
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = View.inflate(getContext(), R.layout.describle_fragment, null);
        }
        ViewGroup parent = (ViewGroup) view.getParent();
        if (parent != null) {
            parent.removeView(view);
        }
        ButterKnife.bind(this, view);
        getData(ret);
        return view;
    }

    private void getData(DetailsBean.RetBean ret) {
        jianActors.setText("主演："+ret.getActors());
        jianDirector.setText("导演："+ret.getDirector());
        jianDescription.setText("简介："+ret.getDescription());
        List<DetailsBean.RetBean.ListBean.ChildListBean> childList = ret.getList().get(0).getChildList();
        GridViewAdapter gridAdapter=new GridViewAdapter(getActivity(),childList);
        jianGrid.setAdapter(gridAdapter);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
