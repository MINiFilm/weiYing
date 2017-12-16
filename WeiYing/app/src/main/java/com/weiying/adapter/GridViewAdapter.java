package com.weiying.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.weiying.R;
import com.weiying.bean.DetailsBean;

import java.util.List;

/**
 * 1.类的用途
 * 2.@author棒棒糖：赵姗杉
 * 3.@date2017/12/16  14：07
 */

public class GridViewAdapter extends BaseAdapter {
    Context context;
    List<DetailsBean.RetBean.ListBean.ChildListBean> childListBeanList;

    public GridViewAdapter(Context context, List<DetailsBean.RetBean.ListBean.ChildListBean> childListBeanList) {
        this.context = context;
        this.childListBeanList = childListBeanList;
    }

    @Override
    public int getCount() {
        return childListBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        return childListBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView==null){
            viewHolder=new ViewHolder();
            convertView=View.inflate(context, R.layout.jian_grid_view,null);
            viewHolder.imageView= (ImageView) convertView.findViewById(R.id.grid_image);
            viewHolder.name= (TextView) convertView.findViewById(R.id.grid_text);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        //Glide.with(context).load(childListBeanList.get(position).getPic());
        Picasso.with(context).load(childListBeanList.get(position).getPic()).into(viewHolder.imageView);
        viewHolder.name.setText(childListBeanList.get(position).getTitle());
        return convertView;
    }
    class ViewHolder{
        TextView name;
        ImageView imageView;
    }
}
