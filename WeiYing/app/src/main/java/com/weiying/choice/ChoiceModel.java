package com.weiying.choice;

import com.weiying.api.Api;
import com.weiying.api.ApiService;
import com.weiying.bean.ChoiceBean;
import com.weiying.utils.RetrofitUtils;

import io.reactivex.Flowable;

/**
 * @Author douya
 * @Time 2017/12/14 19:59.
 */

public class ChoiceModel {
    public Flowable<ChoiceBean> getData(){
        Flowable<ChoiceBean> choiceData = RetrofitUtils.getInstance()
                .getClientApi(ApiService.class, Api.BASEURL)
                .getChoiceData();
        return choiceData;
    }
}
