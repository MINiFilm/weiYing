package com.weiying.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.weiying.R;
import com.weiying.bean.ChoiceBean;
import com.weiying.utils.ChoiceBanner;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 杨圆圆 on 2017/12/14.
 */

public class MyChoiceAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ChoiceBean choiceBean;
    public MyChoiceAdapter(Context context,ChoiceBean choiceBean) {
        this.context = context;
        this.choiceBean=choiceBean;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType==0){
            View inflate = LayoutInflater.from(context).inflate(R.layout.choice_banner, null);
            bannerViewHolder bannerViewHolder=new bannerViewHolder(inflate);
            return bannerViewHolder;
        }
        if(viewType==1){
            View inflate = LayoutInflater.from(context).inflate(R.layout.choice_recycle, null);
            bannerViewHolder bannerViewHolder=new bannerViewHolder(inflate);
            return bannerViewHolder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);


        if(type==0){
            List<String> bannerImgs=new ArrayList<>();
            List<String> bannerTitle=new ArrayList<>();
            List<ChoiceBean.RetBean.ListBean> list = choiceBean.getRet().getList();
            for (int i = 0; i < list.size(); i++) {
                ChoiceBean.RetBean.ListBean listBean = list.get(i);
                if(listBean.getTitle().equals("免费推荐")){
                    List<ChoiceBean.RetBean.ListBean.ChildListBean> childList = listBean.getChildList();
                    for (int j = 0; j < childList.size(); j++) {
                        bannerImgs.add(childList.get(j).getPic());
                        bannerTitle.add(childList.get(j).getTitle());
                    }
                }
            }
            bannerViewHolder b=new bannerViewHolder(holder.itemView);
            //设置样式
            b.choice_banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
            //设置图片集合
            b.choice_banner.setImages(bannerImgs);
            //设置标题集合
            b.choice_banner.setBannerTitles(bannerTitle);
            b.choice_banner.setImageLoader(new ChoiceBanner());
            //是否自动播放
            b.choice_banner.isAutoPlay(true);
            b.choice_banner.setDelayTime(3000);
            b.choice_banner.start();
        }
    }



    @Override
    public int getItemCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        if(position==0){
            return 0;
        }else if(position==1){
            return 1;
        }
        return super.getItemViewType(position);
    }

    public class bannerViewHolder extends RecyclerView.ViewHolder{

        private final Banner choice_banner;

        public bannerViewHolder(View itemView) {
            super(itemView);
            choice_banner = (Banner) itemView.findViewById(R.id.choice_banner);
        }
    }
    public class jinCaiViewHolder extends RecyclerView.ViewHolder{


        private final RecyclerView recycle_jinCai;

        public jinCaiViewHolder(View itemView) {
            super(itemView);
            recycle_jinCai = (RecyclerView) itemView.findViewById(R.id.recycle_JinCai);
        }
    }
}
