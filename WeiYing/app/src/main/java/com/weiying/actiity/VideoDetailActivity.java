package com.weiying.actiity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.shuyu.gsyvideoplayer.video.CustomGSYVideoPlayer;
import com.weiying.R;
import com.weiying.bean.DetailsBean;
import com.weiying.mvp.find_mvp.video_detail.IVideoDetail_View;
import com.weiying.mvp.find_mvp.video_detail.VideoDetail_Presenter;

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
    TableLayout detailTable;
    private VideoDetail_Presenter videoDetail_presenter;
    private ImageView imageView;


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
    }

    @Override
    public void getDetailData(DetailsBean detailsBean) {
        String title = detailsBean.getRet().getTitle();
        Log.i("www", title);
        DetailsBean.RetBean ret = detailsBean.getRet();
        initData(ret);
    }

    private void initData(DetailsBean.RetBean ret) {
        tv_detail_title.setText(ret.getTitle());
        customPlayer.setUp(ret.getSmoothURL(), true);
        Glide.with(this).load(ret.getPic()).into(imageView);
        customPlayer.setThumbImageView(imageView);

    }
}
