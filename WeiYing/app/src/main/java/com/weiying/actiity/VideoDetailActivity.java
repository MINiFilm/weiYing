package com.weiying.actiity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.shuyu.gsyvideoplayer.video.CustomGSYVideoPlayer;
import com.weiying.R;
import com.weiying.bean.DetailsBean;
import com.weiying.fragment.CommendFragment;
import com.weiying.fragment.DescribeFragment;
import com.weiying.mvp.find_mvp.video_detail.IVideoDetail_View;
import com.weiying.mvp.find_mvp.video_detail.VideoDetail_Presenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class VideoDetailActivity extends BaseActivity implements IVideoDetail_View {

    @Bind(R.id.tv_detail_title)
    TextView tv_detail_title;
    @Bind(R.id.custom_player)
    CustomGSYVideoPlayer customPlayer;
    @Bind(R.id.detail_viewpager)
    ViewPager detailViewpager;
    @Bind(R.id.detail_table)
    TabLayout detailTable;

    private VideoDetail_Presenter videoDetail_presenter;
    private ImageView imageView;
    List<String> tab_list = new ArrayList<>();
    List<Fragment> fragments = new ArrayList<>();
    private DetailsBean.RetBean ret;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_detail);
        imageView = new ImageView(this);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String dataId = intent.getStringExtra("dataId");
        Log.i("zss", dataId);
        videoDetail_presenter = new VideoDetail_Presenter(this);
        videoDetail_presenter.getData(dataId);
        getData();

    }

    private void getData() {
        tab_list.add("简介");
        tab_list.add("评论");


    }

    private void getTabLayout() {
        for (int i = 0; i < tab_list.size(); i++) {
            //添加字段
            detailTable.addTab(detailTable.newTab().setText(tab_list.get(i)));
        }
        //滑动模式
        detailTable.setTabMode(TabLayout.MODE_FIXED);
        MyViewPager myViewPager = new MyViewPager(getSupportFragmentManager());
        detailViewpager.setAdapter(myViewPager);
        //设置和ViewPater关联
        detailTable.setupWithViewPager(detailViewpager);
        detailTable.setTabsFromPagerAdapter(myViewPager);
    }

    @Override
    public void getDetailData(DetailsBean detailsBean) {
        String title = detailsBean.getRet().getTitle();
        Log.i("www", title);
        ret = detailsBean.getRet();
        initData(ret);
        DescribeFragment describeFragment=new DescribeFragment();
        Bundle bundle=new Bundle();
        bundle.putSerializable("ret",ret);
        describeFragment.setArguments(bundle);
        fragments.add(describeFragment);
        fragments.add(new CommendFragment());
        getTabLayout();
    }
    private class MyViewPager extends FragmentPagerAdapter {


        @Override
        public CharSequence getPageTitle(int position) {
            return tab_list.get(position);
        }

        public MyViewPager(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }
        @Override
        public int getCount() {
            return fragments.size();
        }
    }
    private void initData(DetailsBean.RetBean ret) {
        tv_detail_title.setText(ret.getTitle());
        customPlayer.setUp(ret.getSmoothURL(), true);
        Glide.with(this).load(ret.getPic()).into(imageView);
        customPlayer.setThumbImageView(imageView);


    }


}
