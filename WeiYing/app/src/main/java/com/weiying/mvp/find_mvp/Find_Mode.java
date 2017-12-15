package com.weiying.mvp.find_mvp;

import com.weiying.api.Api;
import com.weiying.api.ApiService;
import com.weiying.bean.FindBean;
import com.weiying.utils.RetrofitUtils;

import io.reactivex.Flowable;

/**
 * 1.类的用途
 * 2.@author棒棒糖：赵姗杉
 * 3.@date2017/12/15  09：00
 */

public class Find_Mode implements IFind_Mode{

    @Override
    public Flowable<FindBean> gerData(int sum) {
        ApiService apiService = RetrofitUtils
                .getInstance()
                .getClientApi(ApiService.class, Api.BASEURL);
        Flowable<FindBean> findData = apiService
                .getFindData("402834815584e463015584e539330016", sum);
        return findData;
    }
}
