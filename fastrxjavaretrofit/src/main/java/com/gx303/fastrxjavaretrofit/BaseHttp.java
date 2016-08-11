package com.gx303.fastrxjavaretrofit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by gao117348222 on 2016/8/11.
 */

public  class BaseHttp {
    private static OkHttpClient myOkHttpClient;
    public static BaseHttp builder(){
        return new BaseHttp();
    }
    public BaseHttp()
    {
        setMyOkHttpClient();
    }
    public void setOkHttpClient(OkHttpClient client)
    {
        myOkHttpClient=client;
    }
    private void setMyOkHttpClient()
    {
        if(myOkHttpClient==null)
        {
            synchronized (BaseHttp.class)
            {
                myOkHttpClient=new OkHttpClient.Builder()
                        .build();
            }
        }
    }
    public <T> T getService(String baseUrl,Class<T> t1)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(myOkHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit.create(t1);
    }
}
