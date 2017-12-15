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
import com.weiying.bean.SpectialDetailsBean;

import java.util.List;

/**
 * Created by dell-pc on 2017/12/14.
 */

public class MySpecialDetailsAdapter extends RecyclerView.Adapter<MySpecialDetailsAdapter.MyViewHolder> {

    private Context context;
    private List<SpectialDetailsBean.RetBean.ListBean> list;

    public MySpecialDetailsAdapter(Context context, List<SpectialDetailsBean.RetBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.specialdetails_item, parent, false);
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
        SpectialDetailsBean.RetBean.ListBean listBean = list.get(position);
        Log.i("qqq",list.size()+"");
        holder.special_tv.setText(listBean.getTitle());
        holder.special_iv.setImageURI(Uri.parse(listBean.getPic()));
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
            special_iv = (SimpleDraweeView) itemView.findViewById(R.id.specialdetails_iv);
            special_tv = (TextView) itemView.findViewById(R.id.specialdetails_tv);
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
