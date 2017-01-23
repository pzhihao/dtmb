package com.stxpy.dagger.module;

import android.util.Log;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import com.stxpy.constant.URL;
import com.stxpy.service.Loginservice;
import com.stxpy.service.PlayEditService;

import java.io.IOException;

/**
 * Created by Administrator on 2017/1/6.
 */

@Module
public class HttpModule {



    @Singleton
    @Provides
    @Named("string")
    Retrofit provicesRetrofit(){



        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(URL.baseURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();


        return retrofit;
    }
    @Singleton
    @Provides
    @Named("bean")
    Retrofit provicesRetrofitBean(){



        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(URL.baseURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        return retrofit;
    }

    @Singleton
    @Provides
    PlayEditService getApiService(@Named("bean") Retrofit retrofit){
        return retrofit.create(PlayEditService.class);
    }

    @Singleton
    @Provides
    Loginservice getLoginService(@Named("string") Retrofit retrofit){
        return retrofit.create(Loginservice.class);
    }


}
