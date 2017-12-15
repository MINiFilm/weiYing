package com.weiying.mvp.find_mvp;

import com.weiying.api.Api;
import com.weiying.api.ApiService;
import com.weiying.bean.DetailsBean;
import com.weiying.mvp.find_mvp.video_detail.IVideoDetail_Mode;
import com.weiying.utils.RetrofitUtils;

import io.reactivex.Flowable;

/**
 * 1.类的用途
 * 2.@author棒棒糖：赵姗杉
 * 3.@date2017/12/15  20：38
 */

public class VideoDetail_Mode implements IVideoDetail_Mode {
    @Override
    public Flowable<DetailsBean> getDetailData(String dataId) {
        ApiService apiService = RetrofitUtils
                .getInstance()
                .getClientApi(ApiService.class, Api.BASEURL);
        Flowable<DetailsBean> detailsData = apiService
                .getDetailsData(dataId);
        return detailsData;
    }
}
