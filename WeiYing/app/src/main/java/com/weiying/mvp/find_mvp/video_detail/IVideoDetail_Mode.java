package com.weiying.mvp.find_mvp.video_detail;

import com.weiying.bean.DetailsBean;

import io.reactivex.Flowable;

/**
 * 1.类的用途
 * 2.@author棒棒糖：赵姗杉
 * 3.@date2017/12/15  20：38
 */

public interface IVideoDetail_Mode {
    Flowable<DetailsBean> getDetailData(String dataId);
}
