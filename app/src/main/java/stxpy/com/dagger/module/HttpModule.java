package stxpy.com.dagger.module;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import stxpy.com.constant.URL;
import stxpy.com.service.PlayEditService;

/**
 * Created by Administrator on 2017/1/6.
 */

@Module
public class HttpModule {
    @Singleton
    @Provides
    Retrofit provicesRetrofit(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(URL.baseURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
    @Singleton
    @Provides
    PlayEditService getApiService(Retrofit retrofit){
        return retrofit.create(PlayEditService.class);
    }
}
