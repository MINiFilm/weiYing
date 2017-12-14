package com.weiying.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.weiying.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by dell-pc on 2017/12/13.
 */

public class FragmentSpecial extends Fragment {

    @Bind(R.id.rv_special)
    RecyclerView rvSpecial;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_special, container, false);
        ButterKnife.bind(this, view);

 

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
