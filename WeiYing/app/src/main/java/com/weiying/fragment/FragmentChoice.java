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

/**
 * Created by 杨圆圆 on 2017/12/14.
 */

public class FragmentChoice extends Fragment {
    @Bind(R.id.recycleView_Choice)
    RecyclerView choice;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_choice, container, false);

        return inflate;
    }
}
