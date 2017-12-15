package com.weiying.mvp.find_mvp.video_detail;

import com.weiying.bean.DetailsBean;
import com.weiying.mvp.find_mvp.VideoDetail_Mode;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 1.类的用途
 * 2.@author棒棒糖：赵姗杉
 * 3.@date2017/12/15  20：39
 */

public class VideoDetail_Presenter {
    private IVideoDetail_View iVideoDetail_view;
    private IVideoDetail_Mode iVideoDetail_mode;
    private CompositeDisposable disposable;

    public VideoDetail_Presenter(IVideoDetail_View iVideoDetail_view) {
        this.iVideoDetail_view = iVideoDetail_view;
        this.iVideoDetail_mode=new  VideoDetail_Mode();
    }
    public void getData (String dataId){
        disposable = new CompositeDisposable();
        Flowable<DetailsBean> findBeanFlowable = iVideoDetail_mode.getDetailData(dataId);
        findBeanFlowable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<DetailsBean>() {
                    @Override
                    public void accept(DetailsBean detailsBean) throws Exception {
                        iVideoDetail_view.getDetailData(detailsBean);
                    }
                });
    }
}
