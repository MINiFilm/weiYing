package com.weiying.mvp.special_mvp;

import com.weiying.api.Api;
import com.weiying.api.ApiService;
import com.weiying.bean.ChoiceBean;
import com.weiying.utils.RetrofitUtils;

import io.reactivex.Flowable;

/**
 * Created by dell-pc on 2017/12/14.
 */

public class SpecialModelImpl implements SpecialModle {
    @Override
    public Flowable<ChoiceBean> getData() {
        ApiService apiService = RetrofitUtils.getInstance().getClientApi(ApiService.class, Api.BASEURL);
        Flowable<ChoiceBean> flowable = apiService.getChoiceData();
        return flowable;
    }
}
