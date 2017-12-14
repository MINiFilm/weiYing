package com.weiying.mvp.special_mvp;

import com.weiying.bean.ChoiceBean;

import io.reactivex.Flowable;

/**
 * Created by dell-pc on 2017/12/14.
 */

public interface SpecialModle {
     Flowable<ChoiceBean> getData();
}
