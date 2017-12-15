package com.weiying.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.weiying.R;
import com.weiying.bean.ChoiceBean;

import java.util.List;

/**
 * @Author douya
 * @Time 2017/12/15 15:08.
 */

public class MyFunnyAdapter extends RecyclerView.Adapter<MyFunnyAdapter.MyFunnyViewHolder>{
    private Context context;
    private List<ChoiceBean.RetBean.ListBean.ChildListBean> childList;

    public MyFunnyAdapter(Context context, List<ChoiceBean.RetBean.ListBean.ChildListBean> childList) {
        this.context = context;
        this.childList = childList;
    }

    @Override
    public MyFunnyAdapter.MyFunnyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.chioce_recycleitem, parent,false);
        MyFunnyViewHolder viewHolder=new MyFunnyViewHolder(inflate);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyFunnyAdapter.MyFunnyViewHolder holder, int position) {
        ChoiceBean.RetBean.ListBean.ChildListBean childListBean = childList.get(position);
        holder.tv_choiceTitle.setText(childListBean.getTitle());
        holder.iv_choicePic.setImageURI(Uri.parse(childListBean.getPic()));
    }

    @Override
    public int getItemCount() {
        return childList.size();
    }

    public class MyFunnyViewHolder extends RecyclerView.ViewHolder{

        private final ImageView iv_choicePic;
        private final TextView tv_choiceTitle;

        public MyFunnyViewHolder(View itemView) {
            super(itemView);
            iv_choicePic = (ImageView) itemView.findViewById(R.id.iv_choicePic);
            tv_choiceTitle = (TextView) itemView.findViewById(R.id.tv_choiceTitle);
        }
    }
}
