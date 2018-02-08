package com.assesment.di;

import android.content.Context;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by Whizz on 30/1/18.
 */

@Module

public class OkHttpModule {


    @Provides
    @AppScope
    OkHttpClient OkHttpClient(Cache cache){
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.cache(cache);
        return httpClient.build();
    }

    @Provides
    @AppScope
    Cache cache(Context context) {
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
       return new Cache(context.getCacheDir(), cacheSize);
    }


}
