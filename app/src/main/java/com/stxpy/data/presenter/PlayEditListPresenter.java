package com.stxpy.data.presenter;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import com.stxpy.bean.PlayEditBean;
import com.stxpy.constant.URL;


import com.stxpy.dagger.component.DaggerHttpComponent;
import com.stxpy.dagger.component.HttpComponent;
import com.stxpy.data.view.PlayEditListView;
import com.stxpy.service.PlayEditService;

/**
 * Created by Administrator on 2017/1/5.
 */

public class PlayEditListPresenter {


    private PlayEditListView playEditListView;

    @Inject
    PlayEditService editService;

    public PlayEditListPresenter(PlayEditListView playEditListView) {
        this.playEditListView = playEditListView;
        HttpComponent build = DaggerHttpComponent.builder().build();
        build.inject(this);
    }

    public void getPlayEditList(String orgid, String selectedorgid, String state){

        playEditListView.getPlayEditListbefore();

        editService.getplayeditlist(orgid,selectedorgid,state)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<PlayEditBean>>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        s.request(Long.MAX_VALUE);
                    }

                    @Override
                    public void onNext(List<PlayEditBean> list) {
                        playEditListView.getPlayEditListCompleted(list);
                    }

                    @Override
                    public void onError(Throwable t) {
                        playEditListView.getPlayEditListError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        playEditListView.getPlayEditListafter();
                    }
                });

    }

}
