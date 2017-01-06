package stxpy.com.dagger.component;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Component;
import stxpy.com.dagger.AScope;
import stxpy.com.dagger.module.HttpModule;
import stxpy.com.data.presenter.PlayEditListPresenter;

/**
 * Created by Administrator on 2017/1/6.
 */

@Singleton
@Component(modules = {HttpModule.class})
public interface HttpComponent {
    void inject(PlayEditListPresenter playEditListPresenter);
}
