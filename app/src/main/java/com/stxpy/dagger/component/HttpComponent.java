package com.stxpy.dagger.component;

import javax.inject.Singleton;

import dagger.Component;
import com.stxpy.dagger.module.HttpModule;
import com.stxpy.data.presenter.LoginPresenter;
import com.stxpy.data.presenter.PlayEditListPresenter;

/**
 * Created by Administrator on 2017/1/6.
 */

@Singleton
@Component(modules = {HttpModule.class})
public interface HttpComponent {
    void inject(PlayEditListPresenter playEditListPresenter);
    void inject(LoginPresenter loginPresenter);
}
