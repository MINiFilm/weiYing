package com.weiying.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.weiying.R;
import com.weiying.bean.FindBean;

import java.util.List;

/**
 * 1.类的用途
 * 2.@author棒棒糖：赵姗杉
 * 3.@date2017/12/15  15：02
 */

public class MyFindAdapter  extends RecyclerView.Adapter<MyFindAdapter.MyViewHolder>{
    Context context;
    List<FindBean.RetBean.ListBean> dataList;

    public MyFindAdapter(Context context, List<FindBean.RetBean.ListBean> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.find_item, parent, false);
        final MyViewHolder myViewHolder=new MyViewHolder(view);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.itemView.setTag(position);
           Log.i("ddddd",position+"");


        holder.tv_name.setText(""+dataList.get(position).getDescription());
        holder.tv_title.setText(dataList.get(position).getTitle());

        Glide.with(context).load(dataList.get(position).getPic())
                .into(holder.avatarImageView);
    }
    private  SetOnClickItem setItem;
    public  interface SetOnClickItem{
        void setonclickitem(int position);
    }
    public  void setSetOnClickItem(SetOnClickItem setItem) {
        this.setItem = setItem;
    }
    @Override
    public int getItemCount() {
        return dataList.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView avatarImageView;
        TextView tv_title;
        TextView tv_name;
        MyViewHolder(final View itemView) {
            super(itemView);
            avatarImageView = (ImageView) itemView.findViewById(R.id.iv_avatar);
            tv_title= (TextView) itemView.findViewById(R.id.tv_title);
            tv_name= (TextView) itemView.findViewById(R.id.tv_name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position=(int)itemView.getTag();
                    //设置监听
                    if (setItem != null) {
                        setItem.setonclickitem(position);
                    }
                }
            });
        }
    }
}
