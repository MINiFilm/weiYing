package com.weiying.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.weiying.R;
import com.weiying.bean.ChoiceBean;

import java.util.List;

/**
 * Created by dell-pc on 2017/12/14.
 */

public class MySpecialAdapter extends RecyclerView.Adapter<MySpecialAdapter.MyViewHolder> {

    private Context context;
    private List<ChoiceBean.RetBean.ListBean> list;

    public MySpecialAdapter(Context context, List<ChoiceBean.RetBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.special_item, parent, false);
        final MyViewHolder myViewHolder = new MyViewHolder(view);
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClicker.onItemClick(myViewHolder.getPosition());
            }
        });
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        ChoiceBean.RetBean.ListBean listBean = list.get(position);
        Log.i("qqq",list.size()+"");
        holder.special_tv.setText(listBean.getTitle());
        List<ChoiceBean.RetBean.ListBean.ChildListBean> childList = listBean.getChildList();
        for (int i = 0; i < childList.size(); i++) {
            ChoiceBean.RetBean.ListBean.ChildListBean childListBean = childList.get(i);
            holder.special_iv.setImageURI(Uri.parse(childListBean.getPic()));
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private final SimpleDraweeView special_iv;
        private final TextView special_tv;

        public MyViewHolder(View itemView) {
            super(itemView);
            special_iv = (SimpleDraweeView) itemView.findViewById(R.id.special_iv);
            special_tv = (TextView) itemView.findViewById(R.id.special_tv);
        }
    }

    public interface OnClicker{
        void onItemClick(int position);
    }

    public OnClicker onClicker;

    public void setOnClicker(OnClicker onClicker) {
        this.onClicker = onClicker;
    }
}
