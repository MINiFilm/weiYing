package com.weiying.actiity;

import android.content.Intent;
import android.os.Bundle;
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
    private SpecialDetailsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_special_details);
        ButterKnife.bind(this);



        Intent intent = getIntent();
        String detailsCatalogId = intent.getStringExtra("detailsCatalogId");
        String detailsTitle = intent.getStringExtra("detailsTitle");
        tvDetails.setText(detailsTitle);
        Log.i("www",detailsCatalogId);
        presenter = new SpecialDetailsPresenter(this);
        presenter.passDetails(detailsCatalogId);

    }

    @Override
    public void showDetailsData(SpectialDetailsBean spectialDetailsBean) {
        List<SpectialDetailsBean.RetBean.ListBean> listBeen = spectialDetailsBean.getRet().getList();
        Log.i("ppp",listBeen.size()+"");
        rvDetails.setLayoutManager(new GridLayoutManager(SpecialDetailsActivity.this,3));
        MySpecialDetailsAdapter adapter = new MySpecialDetailsAdapter(SpecialDetailsActivity.this,listBeen);
        rvDetails.setAdapter(adapter);
    }
}
