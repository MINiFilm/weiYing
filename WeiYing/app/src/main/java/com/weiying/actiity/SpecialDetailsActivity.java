package com.weiying.actiity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.weiying.R;
import com.weiying.adapter.MySpecialDetailsAdapter;
import com.weiying.bean.SpectialDetailsBean;
import com.weiying.mvp.find_mvp.specialdetails_mvp.SpecialDetailsPresenter;
import com.weiying.mvp.find_mvp.specialdetails_mvp.SpecialDetailsView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SpecialDetailsActivity extends BaseActivity implements SpecialDetailsView {

    @Bind(R.id.tv_details)
    TextView tvDetails;
    @Bind(R.id.rv_details)
    RecyclerView rvDetails;
    @Bind(R.id.swipeRefresh)
    SwipeRefreshLayout swipeRefresh;
    private SpecialDetailsPresenter presenter;
    private MySpecialDetailsAdapter adapter;
    private GridLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_special_details);
        ButterKnife.bind(this);
        layoutManager = new GridLayoutManager(SpecialDetailsActivity.this, 3);
        rvDetails.setLayoutManager(layoutManager);
        Intent intent = getIntent();
        final String detailsCatalogId = intent.getStringExtra("detailsCatalogId");
        String detailsTitle = intent.getStringExtra("detailsTitle");
        tvDetails.setText(detailsTitle);

        presenter = new SpecialDetailsPresenter(this);
        if(adapter == null){
            presenter.passDetails(detailsCatalogId);
        }else{
            adapter.notifyDataSetChanged();
        }

        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.passDetails(detailsCatalogId);
                //如果正在刷新  完成后设置为false
                if(swipeRefresh.isRefreshing()){
                    swipeRefresh.setRefreshing(false);
                }
            }
        });

        rvDetails.addOnScrollListener(new RecyclerView.OnScrollListener() {
            private int lastPosition;
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if(lastPosition+1 == adapter.getItemCount() && newState == RecyclerView.SCROLL_STATE_IDLE){
                    presenter.passDetails(detailsCatalogId);
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastPosition = layoutManager.findLastVisibleItemPosition();
            }
        });

    }

    @Override
    public void showDetailsData(SpectialDetailsBean spectialDetailsBean) {
        final List<SpectialDetailsBean.RetBean.ListBean> listBeen = spectialDetailsBean.getRet().getList();
        Log.i("ppp", listBeen.size() + "");

        adapter = new MySpecialDetailsAdapter(SpecialDetailsActivity.this, listBeen);
        rvDetails.setAdapter(adapter);
        adapter.setOnClicker(new MySpecialDetailsAdapter.OnClicker() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(SpecialDetailsActivity.this,VideoDetailActivity.class);
                intent.putExtra("dataId",listBeen.get(position).getDataId());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestory();
    }
}
