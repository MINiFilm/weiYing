package com.weiying.mvp.find_mvp.specialdetails_mvp;

import com.weiying.bean.SpectialDetailsBean;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by dell-pc on 2017/12/15.
 */

public class SpecialDetailsPresenter{

    CompositeDisposable disposable = null;

    private SpecialDetailsModel specialDetailsModel;
    private SpecialDetailsView specialDetailsView;

    public SpecialDetailsPresenter(SpecialDetailsView specialDetailsView) {
        this.specialDetailsView = specialDetailsView;
        specialDetailsModel = new SpecialDetailsModel();
    }

    public void passDetails(String catetoryId){
        disposable = new CompositeDisposable();
        Flowable<SpectialDetailsBean> flowable = specialDetailsModel.getData(catetoryId);
        DisposableSubscriber<SpectialDetailsBean> disposableSubscriber = flowable.subscribeOn(Schedulers.io())
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
        disposable.add(disposableSubscriber);
    }

    public void onDestory(){
        if(disposable != null){
            disposable.dispose();
            specialDetailsView = null;
        }
    }

}
