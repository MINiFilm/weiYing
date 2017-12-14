package com.weiying.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 杨圆圆 on 2017/12/14.
 */

public class MyChoiceAdapter extends RecyclerView.Adapter<MyChoiceAdapter.MyChoiceViewHolder> {
    @Override
    public MyChoiceAdapter.MyChoiceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(MyChoiceAdapter.MyChoiceViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyChoiceViewHolder extends RecyclerView.ViewHolder{
        public MyChoiceViewHolder(View itemView) {
            super(itemView);
        }
    }
}
