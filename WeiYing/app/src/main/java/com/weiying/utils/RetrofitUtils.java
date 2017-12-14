package com.weiying.utils;

import android.util.Log;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 1. 类的用途
 * 2. @author forever
 * 3. @date 2017/5/13 10:32
 */

public class RetrofitUtils {

    private Retrofit retrofit;
    //单例设计模式
    //懒汉 只声明不创建 私有的静态的 成员变量
    private static RetrofitUtils apiRetrofit = null;

    //私有的构造方法
    private RetrofitUtils() {
    }
    //提供一个公共的返回实例的静态方法
    public static RetrofitUtils getInstance() {
        if (apiRetrofit == null) {
            synchronized (RetrofitUtils.class) {
                if (apiRetrofit == null) {
                    apiRetrofit = new RetrofitUtils();
                }
            }
        }
        return apiRetrofit;
    }

    /**
     * 文件上传
     * @return   多个参数
     */
    public List<MultipartBody.Part> loadFile(Map<String,Object> map){
        MultipartBody.Builder setType = new MultipartBody.Builder().setType(MultipartBody.FORM);
        for(Map.Entry<String,Object> entry : map.entrySet()){
            Object value = entry.getValue();
            if (value instanceof File){
                File file = (File) value;
                setType.addFormDataPart(entry.getKey(),file.getName(), RequestBody.create(MediaType.parse("application/otcet-stream"),file));
            }else{
                setType.addFormDataPart(entry.getKey(),value.toString());
            }
        }
        //返回一个集合
        return setType.build().parts();
    }

    //获取Retrofit实例
    public Retrofit getRetrofit(String path) {
        //打印retrofit日志
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(final String message) {
                //打印retrofit日志
                Log.i("RetrofitLog", "retrofitBack = " + message);
            }
        });

        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //创建OkHttpClient
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(5000, TimeUnit.SECONDS);
        builder.readTimeout(5000, TimeUnit.SECONDS);
        builder.writeTimeout(5000, TimeUnit.SECONDS);
        builder.retryOnConnectionFailure(true);
        builder.addInterceptor(loggingInterceptor);
        OkHttpClient okHttpClient = builder.build();
        //创建Retrofit
        retrofit = new Retrofit.Builder()
                .baseUrl(path)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit;
    }

    //封装参数的接口对象
    public <T> T getClientApi(Class<T> cla, String path) {
        Retrofit retrofit = getRetrofit(path);
        return retrofit.create(cla);
    }
}
