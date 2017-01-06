package stxpy.com.data.presenter;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import stxpy.com.bean.PlayEditBean;
import stxpy.com.constant.URL;
import stxpy.com.data.view.PlayEditListView;
import stxpy.com.service.PlayEditService;

/**
 * Created by Administrator on 2017/1/5.
 */

public class PlayEditListPresenter {
    private PlayEditListView playEditListView;

    public PlayEditListPresenter(PlayEditListView playEditListView) {
        this.playEditListView = playEditListView;
    }

    public void getPlayEditList(String orgid, String selectedorgid, String state){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(URL.baseURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        playEditListView.getPlayEditListbefore();
        PlayEditService playEditService = retrofit.create(PlayEditService.class);
        playEditService.getplayeditlist(orgid,selectedorgid,state)
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
