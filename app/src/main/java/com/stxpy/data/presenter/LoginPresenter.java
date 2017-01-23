package com.stxpy.data.presenter;






import com.stxpy.dagger.component.DaggerHttpComponent;
import com.stxpy.dagger.component.HttpComponent;
import com.stxpy.data.view.ILoginView;
import com.stxpy.service.Loginservice;


import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;


import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by Administrator on 2017/1/18.
 */

public class LoginPresenter {
    ILoginView loginView;

    @Inject
    Loginservice editService;

    public LoginPresenter(ILoginView loginView) {
        this.loginView = loginView;
        HttpComponent build = DaggerHttpComponent.builder().build();
        build.inject(this);
    }
    public void getLoginResult(String name,String pass){
        loginView.getLoginbefore();
        editService.getloginResult(name,pass)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        s.request(Long.MAX_VALUE);
                    }

                    @Override
                    public void onNext(String s) {
                        loginView.getLoginCompleted(s);
                    }

                    @Override
                    public void onError(Throwable t) {
                        loginView.getLoginError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        loginView.getLoginafter();
                    }
                });
    }
}
