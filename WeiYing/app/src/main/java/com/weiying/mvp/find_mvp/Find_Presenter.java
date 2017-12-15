package com.weiying.mvp.find_mvp;

import com.weiying.bean.FindBean;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * 1.类的用途
 * 2.@author棒棒糖：赵姗杉
 * 3.@date2017/12/15  09：30
 */

public class Find_Presenter {
    private IFind_View iFind_view;
    private IFind_Mode iFind_mode;
    private CompositeDisposable disposable;
    public Find_Presenter(IFind_View iFind_view) {
        this.iFind_view = iFind_view;
        iFind_mode=new Find_Mode();
    }

    public void getData(int num){
        disposable = new CompositeDisposable();
        Flowable<FindBean> findBeanFlowable = iFind_mode.gerData(num);
        DisposableSubscriber<FindBean> disposableSubscriber=findBeanFlowable
        .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<FindBean>() {
                    @Override
                    public void onNext(FindBean findBean) {
                        iFind_view.showData(findBean);
                    }
                    @Override
                    public void onError(Throwable t) {}
                    @Override
                    public void onComplete() {}
                });


    }

}
