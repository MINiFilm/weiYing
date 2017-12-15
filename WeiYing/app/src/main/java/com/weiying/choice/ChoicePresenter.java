package com.weiying.choice;

import com.weiying.bean.ChoiceBean;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * @Author douya
 * @Time 2017/12/14 20:01.
 */

public class ChoicePresenter {
    private ChoiceView choiceView;
    private final ChoiceModel choiceModel;
    private CompositeDisposable disposable;

    public ChoicePresenter(ChoiceView choiceView) {
        this.choiceView = choiceView;
        choiceModel = new ChoiceModel();
    }

    public void getCData(){
        disposable = new CompositeDisposable();
        Flowable<ChoiceBean> data = choiceModel.getData();
        DisposableSubscriber<ChoiceBean> disposableSubscriber = data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<ChoiceBean>() {
                    @Override
                    public void onNext(ChoiceBean bean) {
                        choiceView.getChoiceData(bean);
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
    public void onDestroy(){
        if(disposable!=null&&!disposable.isDisposed()){
            disposable.dispose();
        }
    }
}
