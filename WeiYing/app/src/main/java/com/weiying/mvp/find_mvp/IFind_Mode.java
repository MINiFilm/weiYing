package com.weiying.mvp.find_mvp;

import com.weiying.bean.FindBean;

import io.reactivex.Flowable;

/**
 * 1.类的用途
 * 2.@author棒棒糖：赵姗杉
 * 3.@date2017/12/15  09：01
 */

public interface IFind_Mode {
    Flowable<FindBean> gerData(int sum);


}
