package com.wolf.liuxue.http;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by nanchaodong on 2017/5/5.
 */

public class Api {
    private static ApiService service;
    private final static int DEFAULT_TIMEOUT = 10000;
    public static ApiService getDefault(){
        if (service == null){
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
            service = new Retrofit.Builder()
                    .client(builder.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .baseUrl("http://innerapi.jiemodou.net/")
                    .build()
                    .create(ApiService.class);
        }
        return service;
    }
}
