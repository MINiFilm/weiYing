package com.weiying.mvp.find_mvp.specialdetails_mvp;

import com.weiying.bean.SpectialDetailsBean;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by dell-pc on 2017/12/15.
 */

public class SpecialDetailsPresenter {

    private SpecialDetailsModel specialDetailsModel;
    private SpecialDetailsView specialDetailsView;

    public SpecialDetailsPresenter(SpecialDetailsView specialDetailsView) {
        this.specialDetailsView = specialDetailsView;
        specialDetailsModel = new SpecialDetailsModel();
    }

    public void passDetails(String catetoryId){
        Flowable<SpectialDetailsBean> flowable = specialDetailsModel.getData(catetoryId);
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<SpectialDetailsBean>() {
                    @Override
                    public void onNext(SpectialDetailsBean spectialDetailsBean) {
                        specialDetailsView.showDetailsData(spectialDetailsBean);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
