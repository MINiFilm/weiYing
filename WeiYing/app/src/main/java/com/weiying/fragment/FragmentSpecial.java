package com.weiying.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.weiying.R;
import com.weiying.adapter.MySpecialAdapter;
import com.weiying.bean.ChoiceBean;
import com.weiying.choice.ChoicePresenter;
import com.weiying.choice.ChoiceView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by dell-pc on 2017/12/13.
 */

public class FragmentSpecial extends Fragment implements ChoiceView {

    @Bind(R.id.rv_special)
    RecyclerView rvSpecial;

    ChoicePresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_special, container, false);
        ButterKnife.bind(this, view);

        presenter = new ChoicePresenter(this);
        presenter.getCData();

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void getChoiceData(ChoiceBean bean) {
        List<ChoiceBean.RetBean.ListBean> list = bean.getRet().getList();
        rvSpecial.setLayoutManager(new GridLayoutManager(getActivity(),2));
        MySpecialAdapter adapter = new MySpecialAdapter(getActivity(),list);
        rvSpecial.setAdapter(adapter);
    }
}
