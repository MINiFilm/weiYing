package com.weiying.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.weiying.R;
import com.weiying.adapter.MyChoiceAdapter;
import com.weiying.bean.ChoiceBean;
import com.weiying.choice.ChoicePresenter;
import com.weiying.choice.ChoiceView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 杨圆圆 on 2017/12/14.
 */

public class FragmentChoice extends Fragment implements ChoiceView {

    @Bind(R.id.recycleView_Choice)
    RecyclerView recycleViewChoice;
    private ChoicePresenter choicePresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_choice, container, false);
        ButterKnife.bind(this, inflate);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        recycleViewChoice.setLayoutManager(manager);
        choicePresenter = new ChoicePresenter(this);
        choicePresenter.getCData();

        return inflate;
    }

    @Override
    public void getChoiceData(ChoiceBean bean) {
        MyChoiceAdapter adapter=new MyChoiceAdapter(getContext(),bean);
        recycleViewChoice.setAdapter(adapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        choicePresenter.onDestroy();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
