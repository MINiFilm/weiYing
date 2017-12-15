package com.weiying.mvp.find_mvp.specialdetails_mvp;

import com.weiying.api.Api;
import com.weiying.api.ApiService;
import com.weiying.bean.SpectialDetailsBean;
import com.weiying.utils.RetrofitUtils;

import io.reactivex.Flowable;

/**
 * Created by dell-pc on 2017/12/15.
 */

public class SpecialDetailsModel {

    public Flowable<SpectialDetailsBean> getData(String catetoryId){
        ApiService clientApi = RetrofitUtils.getInstance().getClientApi(ApiService.class, Api.BASEURL);
        Flowable<SpectialDetailsBean> flowable = clientApi.getSpecialDetailsData(catetoryId);
        return flowable;
    }

}
