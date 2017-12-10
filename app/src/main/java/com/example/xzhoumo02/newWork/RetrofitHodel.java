package com.example.xzhoumo02.newWork;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 绅丶士 on 2017/12/9.
 */

public class RetrofitHodel {
    private static OkHttpClient okHttpClient;
    private static SerevsApi serevsApi;
    static {
        initRetrofitHolder();
    }

    private static void initRetrofitHolder(){
        if(okHttpClient==null){
            synchronized (RetrofitHodel.class){
                if(okHttpClient==null){
                    okHttpClient=new OkHttpClient.Builder().build();
                }
            }
        }
    }

    public static SerevsApi getApi(){
        if(serevsApi==null){
            synchronized (SerevsApi.class){
                if(serevsApi==null){
                    serevsApi=RetrofitHodel.caretaApi(SerevsApi.class,UrlUtils.HOST);
                }
            }
        }
        return serevsApi;
    }

    /**
     *
     * @param clazz
     * @param url
     * @param <T>
     * @return
     */
    public static <T> T caretaApi(Class<T> clazz,String url){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(UrlUtils.HOST)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(clazz);
    }
}
